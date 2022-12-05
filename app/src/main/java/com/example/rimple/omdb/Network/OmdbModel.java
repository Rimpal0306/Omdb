package com.example.rimple.omdb.Network;

import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OmdbModel implements Serializable, Parcelable {

    public final static Creator<OmdbModel> CREATOR = new Creator<OmdbModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public OmdbModel createFromParcel(android.os.Parcel in) {
            return new OmdbModel(in);
        }

        public OmdbModel[] newArray(int size) {
            return (new OmdbModel[size]);
        }

    };
    private final static long serialVersionUID = 510401712578431686L;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("Rated")
    @Expose
    private String rated;
    @SerializedName("Released")
    @Expose
    private String released;
    @SerializedName("Runtime")
    @Expose
    private String runtime;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Writer")
    @Expose
    private String writer;
    @SerializedName("Actors")
    @Expose
    private String actors;
    @SerializedName("Plot")
    @Expose
    private String plot;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Awards")
    @Expose
    private String awards;
    @SerializedName("Poster")
    @Expose
    private String poster;
    @SerializedName("Ratings")
    @Expose
    private List<Rating> ratings = null;
    @SerializedName("Metascore")
    @Expose
    private String metascore;
    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;
    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;
    @SerializedName("imdbID")
    @Expose
    private String imdbID;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("DVD")
    @Expose
    private String dvd;
    @SerializedName("BoxOffice")
    @Expose
    private String boxOffice;
    @SerializedName("Production")
    @Expose
    private String production;
    @SerializedName("Website")
    @Expose
    private String website;
    @SerializedName("Response")
    @Expose
    private String response;

    protected OmdbModel(android.os.Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.year = ((String) in.readValue((String.class.getClassLoader())));
        this.rated = ((String) in.readValue((String.class.getClassLoader())));
        this.released = ((String) in.readValue((String.class.getClassLoader())));
        this.runtime = ((String) in.readValue((String.class.getClassLoader())));
        this.genre = ((String) in.readValue((String.class.getClassLoader())));
        this.director = ((String) in.readValue((String.class.getClassLoader())));
        this.writer = ((String) in.readValue((String.class.getClassLoader())));
        this.actors = ((String) in.readValue((String.class.getClassLoader())));
        this.plot = ((String) in.readValue((String.class.getClassLoader())));
        this.language = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.awards = ((String) in.readValue((String.class.getClassLoader())));
        this.poster = ((String) in.readValue((String.class.getClassLoader())));
        this.metascore = ((String) in.readValue((String.class.getClassLoader())));
        this.imdbRating = ((String) in.readValue((String.class.getClassLoader())));
        this.imdbVotes = ((String) in.readValue((String.class.getClassLoader())));
        this.imdbID = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.dvd = ((String) in.readValue((String.class.getClassLoader())));
        this.boxOffice = ((String) in.readValue((String.class.getClassLoader())));
        this.production = ((String) in.readValue((String.class.getClassLoader())));
        this.website = ((String) in.readValue((String.class.getClassLoader())));
        this.response = ((String) in.readValue((String.class.getClassLoader())));
    }

    public OmdbModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OmdbModel withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public OmdbModel withYear(String year) {
        this.year = year;
        return this;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public OmdbModel withRated(String rated) {
        this.rated = rated;
        return this;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public OmdbModel withReleased(String released) {
        this.released = released;
        return this;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public OmdbModel withRuntime(String runtime) {
        this.runtime = runtime;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public OmdbModel withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public OmdbModel withDirector(String director) {
        this.director = director;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public OmdbModel withWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public OmdbModel withActors(String actors) {
        this.actors = actors;
        return this;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public OmdbModel withPlot(String plot) {
        this.plot = plot;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public OmdbModel withLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public OmdbModel withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public OmdbModel withAwards(String awards) {
        this.awards = awards;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public OmdbModel withPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public OmdbModel withRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public OmdbModel withMetascore(String metascore) {
        this.metascore = metascore;
        return this;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public OmdbModel withImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
        return this;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public OmdbModel withImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
        return this;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public OmdbModel withImdbID(String imdbID) {
        this.imdbID = imdbID;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OmdbModel withType(String type) {
        this.type = type;
        return this;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public OmdbModel withDvd(String dvd) {
        this.dvd = dvd;
        return this;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public OmdbModel withBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
        return this;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public OmdbModel withProduction(String production) {
        this.production = production;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public OmdbModel withWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public OmdbModel withResponse(String response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OmdbModel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append(',');
        sb.append("year");
        sb.append('=');
        sb.append(((this.year == null) ? "<null>" : this.year));
        sb.append(',');
        sb.append("rated");
        sb.append('=');
        sb.append(((this.rated == null) ? "<null>" : this.rated));
        sb.append(',');
        sb.append("released");
        sb.append('=');
        sb.append(((this.released == null) ? "<null>" : this.released));
        sb.append(',');
        sb.append("runtime");
        sb.append('=');
        sb.append(((this.runtime == null) ? "<null>" : this.runtime));
        sb.append(',');
        sb.append("genre");
        sb.append('=');
        sb.append(((this.genre == null) ? "<null>" : this.genre));
        sb.append(',');
        sb.append("director");
        sb.append('=');
        sb.append(((this.director == null) ? "<null>" : this.director));
        sb.append(',');
        sb.append("writer");
        sb.append('=');
        sb.append(((this.writer == null) ? "<null>" : this.writer));
        sb.append(',');
        sb.append("actors");
        sb.append('=');
        sb.append(((this.actors == null) ? "<null>" : this.actors));
        sb.append(',');
        sb.append("plot");
        sb.append('=');
        sb.append(((this.plot == null) ? "<null>" : this.plot));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null) ? "<null>" : this.language));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null) ? "<null>" : this.country));
        sb.append(',');
        sb.append("awards");
        sb.append('=');
        sb.append(((this.awards == null) ? "<null>" : this.awards));
        sb.append(',');
        sb.append("poster");
        sb.append('=');
        sb.append(((this.poster == null) ? "<null>" : this.poster));
        sb.append(',');
        sb.append("ratings");
        sb.append('=');
        sb.append(((this.ratings == null) ? "<null>" : this.ratings));
        sb.append(',');
        sb.append("metascore");
        sb.append('=');
        sb.append(((this.metascore == null) ? "<null>" : this.metascore));
        sb.append(',');
        sb.append("imdbRating");
        sb.append('=');
        sb.append(((this.imdbRating == null) ? "<null>" : this.imdbRating));
        sb.append(',');
        sb.append("imdbVotes");
        sb.append('=');
        sb.append(((this.imdbVotes == null) ? "<null>" : this.imdbVotes));
        sb.append(',');
        sb.append("imdbID");
        sb.append('=');
        sb.append(((this.imdbID == null) ? "<null>" : this.imdbID));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append(',');
        sb.append("dvd");
        sb.append('=');
        sb.append(((this.dvd == null) ? "<null>" : this.dvd));
        sb.append(',');
        sb.append("boxOffice");
        sb.append('=');
        sb.append(((this.boxOffice == null) ? "<null>" : this.boxOffice));
        sb.append(',');
        sb.append("production");
        sb.append('=');
        sb.append(((this.production == null) ? "<null>" : this.production));
        sb.append(',');
        sb.append("website");
        sb.append('=');
        sb.append(((this.website == null) ? "<null>" : this.website));
        sb.append(',');
        sb.append("response");
        sb.append('=');
        sb.append(((this.response == null) ? "<null>" : this.response));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(year);
        dest.writeValue(rated);
        dest.writeValue(released);
        dest.writeValue(runtime);
        dest.writeValue(genre);
        dest.writeValue(director);
        dest.writeValue(writer);
        dest.writeValue(actors);
        dest.writeValue(plot);
        dest.writeValue(language);
        dest.writeValue(country);
        dest.writeValue(awards);
        dest.writeValue(poster);
        dest.writeList(ratings);
        dest.writeValue(metascore);
        dest.writeValue(imdbRating);
        dest.writeValue(imdbVotes);
        dest.writeValue(imdbID);
        dest.writeValue(type);
        dest.writeValue(dvd);
        dest.writeValue(boxOffice);
        dest.writeValue(production);
        dest.writeValue(website);
        dest.writeValue(response);
    }

    public int describeContents() {
        return 0;
    }

}