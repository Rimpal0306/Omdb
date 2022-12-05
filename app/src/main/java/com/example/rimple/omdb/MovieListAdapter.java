package com.example.rimple.omdb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rimple.omdb.Database.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>{


    private static ClickListener mClickHandler;
    private List<Movie> modelList = new ArrayList<>();

    public interface ClickListener{
       void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        MovieListAdapter.mClickHandler = clickListener;
    }

    public MovieListAdapter() {
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.item_movie;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.titleTV.setText(modelList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return modelList.size();

    }

    @SuppressLint("NotifyDataSetChanged")
    public void setModelForList(List<Movie> model) {
        modelList = model;
        notifyDataSetChanged();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleTV;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.tvRVTitle);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            mClickHandler.onItemClick(getAdapterPosition(),v);
        }
    }
}
