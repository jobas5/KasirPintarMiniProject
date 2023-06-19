package com.example.miniproject.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.miniproject.room.Barang;
import com.example.miniproject.room.BarangDao;
import com.example.miniproject.room.BarangDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BarangRepository {

    private final BarangDao barangDao;
    private final LiveData<List<Barang>> allBarang;
    private final Executor executor;

    public BarangRepository(Application application) {
        BarangDatabase database = BarangDatabase.getInstance(application);
        barangDao = database.barangDao();
        allBarang = barangDao.getAllBarang();
        executor = Executors.newSingleThreadExecutor();
    }

    public void insert(Barang barang) {
        executor.execute(() -> barangDao.insert(barang));
    }

    public void update(Barang barang) {
        executor.execute(() -> barangDao.update(barang));
    }

    public void delete(Barang barang) {
        executor.execute(() -> barangDao.delete(barang));
    }

    public void deleteAllBarang() {
        executor.execute(barangDao::deleteAllBarang);
    }

    public LiveData<List<Barang>> getAllBarang() {
        return allBarang;
    }
}
