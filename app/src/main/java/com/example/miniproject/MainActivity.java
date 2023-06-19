package com.example.miniproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.adapters.BarangAdapter;
import com.example.miniproject.models.BarangViewModel;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    BarangViewModel barangViewModel;
    TextView tvTitle;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // ---------- APP BAR TITLE ---------- //
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Daftar Barang");

        // ---------- Set Status Bar Color ---------- //
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color));
        Objects.requireNonNull(getSupportActionBar()).hide();


        // ---------- RECYCLER VIEW ---------- //
        RecyclerView RVDaftarBarang = findViewById(R.id.RVDaftarBarang);
        RVDaftarBarang.setLayoutManager(new LinearLayoutManager(this));
        RVDaftarBarang.setHasFixedSize(true);

        final BarangAdapter adapter = new BarangAdapter();
        RVDaftarBarang.setAdapter(adapter);

        barangViewModel = new ViewModelProvider(this).get(BarangViewModel.class);
        barangViewModel.getAllBarang().observe(this, barangs -> {
            adapter.setBarangs(barangs); // Update the adapter's data
            Toast.makeText(MainActivity.this, "Data changed", Toast.LENGTH_SHORT).show();
        });

    }


}
