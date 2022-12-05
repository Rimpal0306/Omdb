package com.example.rimple.omdb.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movie")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getUrl() {
        return url;
    }

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "year")
    private String year;

    @ColumnInfo(name = "rating")
    private String rating;

    @ColumnInfo(name = "runtime")
    private String runtime;

    @ColumnInfo(name = "actors")
    private String actors;

    @ColumnInfo(name = "plot")
    private String plot;

    @ColumnInfo(name = "url")
    private String url;

    public Movie( String title, String year, String rating, String runtime, String actors, String plot, String url) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.runtime = runtime;
        this.actors = actors;
        this.plot = plot;
        this.url = url;
    }
}
