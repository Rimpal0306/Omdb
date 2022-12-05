package com.example.rimple.omdb.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDAO {

    @Query("Select * from movie")
    List<Movie> getFavouriteList();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addFavourite(Movie movie);

    @Query("DELETE FROM movie WHERE plot = :plot")
    int removeFavourite(String plot);

    @Query("DELETE FROM movie")
    void delete();
    @Query("SELECT * FROM movie WHERE plot = :plot")
    int isDataExist(String plot);

}
