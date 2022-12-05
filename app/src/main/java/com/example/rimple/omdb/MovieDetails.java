package com.example.rimple.omdb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.rimple.omdb.Database.Movie;
import com.example.rimple.omdb.Database.MovieDAO;
import com.example.rimple.omdb.Database.MovieDataBase;
import com.example.rimple.omdb.databinding.MovieDetailsBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDetails extends AppCompatActivity {

    MovieDetailsBinding binding;
    Menu fav;
    List<Movie> favMoviesList;
    private boolean isFavourite = false;
    MovieDAO movieDAO;
    private Movie movieObject;
    private String title;
    private String year;
    private String rating;
    private String runtime;
    private String actors;
    private String plot;
    private String url;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MovieDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        movieDAO = MovieDataBase.getInstance(this).movieDAO();
        favMoviesList = movieDAO.getFavouriteList();

        if (getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            id = bundle.getString("id", "");
            title = bundle.getString("title");
            binding.tvTitle.setText(title);
            year = bundle.getString("year");
            binding.tvYear.setText(year);
            rating = bundle.getString("rating","");
            binding.tvRating.setText(rating);
            runtime = bundle.getString("runtime");
            binding.tvRuntime.setText(runtime);
            actors = bundle.getString("actors");
            binding.tvMainActors.setText(actors);
            plot = bundle.getString("plot");
            binding.tvPlot.setText(plot);
            url = bundle.getString("poster");
            movieObject = new Movie(title,year,rating,runtime,actors,plot,url);

            Glide
                    .with(this)
                    .load(url)
                    .centerCrop()
                    .into(binding.ivPoster);

        }

        checkIfMovieFavourited(movieObject);
    }


    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        super.onCreatePanelMenu(featureId, menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_fav, menu);
        this.fav = menu;
        updateIcon();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fav:
                item.setCheckable(false);
                if (!isFavourite) {
                    addMovieTOFav();
                    Snackbar.make(findViewById(android.R.id.content), "Movie added to Favourites!", Snackbar.LENGTH_LONG).show();
                } else {
                    removeMovieFromFav();
                    Snackbar.make(findViewById(android.R.id.content), "Movie removed from Favourites!", Snackbar.LENGTH_LONG).show();
                }
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
        }

            return super.onOptionsItemSelected(item);
        }

    private void addMovieTOFav() {
        checkIfMovieFavourited(movieObject);
        if(!isFavourite) {
            long insertId = movieDAO.addFavourite(movieObject);
            isFavourite = true;
            updateIcon();
            movieObject.setId(insertId);
        }

    }


    private void updateIcon() {
        if (isFavourite) {
            fav.findItem(R.id.fav).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24));
        } else {
            fav.findItem(R.id.fav).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24));
        }
    }

    /**
     * Remove from db
     */
    private void removeMovieFromFav() {
        long id = movieObject.getId();
        int val = movieDAO.removeFavourite(movieObject.getPlot());
        isFavourite = false;
        updateIcon();
    }

    /**
     * Check if the entry is available in DATABASE
     * @param movieObject
     */
    private void checkIfMovieFavourited(Movie movieObject){
        long id = movieObject.getId();
//        for(Movie x: favMoviesList) {
//            isFavourite = Objects.equals(x.getId(), movieObject.getId());
//        }
        if(movieDAO.isDataExist(movieObject.getPlot())==0) { //if 0 = data does not exist in table
            isFavourite = false;
        }else {
            isFavourite = true;
        }
    }
}