package com.example.coches.BD;

//ESTA CLASE NO VA

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.coches.Api.Coche;

@Database(entities = {Coche.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class, "db"
                    ).build();
        }
        return INSTANCE;
    }

    public abstract cocheDao getCocheDao();
}


