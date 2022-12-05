package com.example.rimple.omdb.Network;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbAPI {
    @GET("/?apikey=6c9862c2")
    Call<OmdbModel> listSearchedMovies(@Query("t") String title);

    class Factory {
        private static OmdbAPI service;

        public static OmdbAPI getInstance() {
            if (service == null) {
                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://www.omdbapi.com/")
                        .build();

                service = retrofit.create(OmdbAPI.class);
            }
            return service;
        }
    }
}
