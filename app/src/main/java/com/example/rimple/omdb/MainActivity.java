package com.example.rimple.omdb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import com.example.rimple.omdb.Database.Movie;
import com.example.rimple.omdb.Database.MovieDAO;
import com.example.rimple.omdb.Database.MovieDataBase;
import com.example.rimple.omdb.Network.OmdbAPI;
import com.example.rimple.omdb.Network.OmdbModel;
import com.example.rimple.omdb.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//Rimpal//
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    MovieDAO movieDAO;
    private MovieListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setTitle("Rimple ");
        movieDAO = MovieDataBase.getInstance(this).movieDAO();
        adapter = new MovieListAdapter();
        adapter.setOnItemClickListener(new MovieListAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(getApplicationContext(), MovieDetails.class);
                Movie movie = movieDAO.getFavouriteList().get(position);
                intent.putExtra("id", movie.getId());
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("year", movie.getYear());
                intent.putExtra("rating",movie.getRating());
                intent.putExtra("runtime", movie.getRuntime());
                intent.putExtra("actors", movie.getActors());
                intent.putExtra("plot", movie.getPlot());
                intent.putExtra("poster", movie.getUrl());
                startActivity(intent);
            }
        });


        binding.rvSavedList.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        binding.rvSavedList.setLayoutManager(new LinearLayoutManager(this));
        binding.etMovieTitle.getText();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.etMovieTitle.getText().toString();
                if (!title.isEmpty()) {
                    OmdbAPI.Factory.getInstance().listSearchedMovies(title).enqueue(new Callback<OmdbModel>() {
                        @Override
                        public void onResponse(Call<OmdbModel> call, @NonNull Response<OmdbModel> response) {
                            Intent intent = new Intent(getApplicationContext(), MovieDetails.class);
                            intent.putExtra("title", response.body().getTitle());
                            intent.putExtra("year", response.body().getYear());
                            if(response.body().getRatings().size()>0) {
                                intent.putExtra("rating", response.body().getRatings().get(0).getValue());
                            }
                            intent.putExtra("runtime", response.body().getRuntime());
                            intent.putExtra("actors", response.body().getActors());
                            intent.putExtra("plot", response.body().getPlot());
                            intent.putExtra("poster", response.body().getPoster());
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<OmdbModel> call, Throwable t) {
                            Snackbar.make(view,
                                    "Could not find movie details Error in network call", Snackbar.LENGTH_LONG).show();                      }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Please enter movie name first to search details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("searchText", binding.etMovieTitle.getText().toString());
        myEdit.commit();
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("etText",binding.etMovieTitle.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        binding.etMovieTitle.setText(savedInstanceState.getString("etText"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Movie> moviesList = movieDAO.getFavouriteList();
        adapter.setModelForList(moviesList);
        binding.rvSavedList.setAdapter(adapter);
        SharedPreferences sh = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        String text = sh.getString("searchText","");
        binding.etMovieTitle.setText(text);
    }
}