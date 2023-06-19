package com.example.miniproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BarangViewModel extends AndroidViewModel {
    private final BarangRepository repository;
    private final LiveData<List<Barang>> allBarang;

    public BarangViewModel(@NonNull Application application) {
        super(application);
        repository = new BarangRepository(application);
        allBarang = repository.getAllBarang();
    }

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
