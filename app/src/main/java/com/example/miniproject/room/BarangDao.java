package com.example.miniproject.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.miniproject.room.Barang;

import java.util.List;

@Dao
public interface BarangDao {

    @Insert
    void insert(Barang barang);

    @Update
    void update(Barang barang);

    @Delete
    void delete(Barang barang);

    @Query("DELETE FROM tabel_barang")
    void deleteAllBarang();

    @Query("SELECT * FROM tabel_barang ORDER BY stok DESC")
    LiveData<List<Barang>> getAllBarang();
}
