package com.example.coches.BD;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.coches.Api.Coche;

import java.util.List;

@Dao
public interface cocheDao {
    @Query("select * from Coche")
    LiveData<List<Coche>> getCoches();

    @Insert
    void addCoche(Coche coche);

    @Insert
    void addCoches(List<Coche> coches);

    @Delete
    void deleteCoche(Coche coche);

    @Query("DELETE FROM Coche")
    void deleteCoches();

}
