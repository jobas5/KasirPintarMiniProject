package com.example.miniproject.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.miniproject.room.Barang;
import com.example.miniproject.repositories.BarangRepository;

import java.util.List;

public class BarangViewModel extends AndroidViewModel {
    private final BarangRepository repository;
    private final LiveData<List<Barang>> allBarang;

    public BarangViewModel(@NonNull Application application) {
        super(application);
        repository = new BarangRepository(application);
        allBarang = repository.getAllBarang();
    }

    //Next function to do simple CRUD of Barang
    public void insert(Barang barang) {
        repository.insert(barang);
    }

    public void update(Barang barang) {
        repository.update(barang);
    }

    public void delete(Barang barang) {
        repository.delete(barang);
    }

    public void deleteAllBarang() {
        repository.deleteAllBarang();
    }

    public LiveData<List<Barang>> getAllBarang() {
        return allBarang;
    }
}
