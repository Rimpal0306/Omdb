package com.example.rimple.omdb.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Movie.class}, version = 1)
public abstract class MovieDataBase extends RoomDatabase {

    private static MovieDataBase instance;
    public abstract MovieDAO movieDAO();

    public static synchronized MovieDataBase getInstance(Context context) {

        if (instance == null) {

            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                                    MovieDataBase.class, "movie")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .addCallback(roomCallback)
                            .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(MovieDataBase instance) {
            MovieDAO dao = instance.movieDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
