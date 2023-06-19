package com.example.miniproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;


public class DetailBarangActivity extends AppCompatActivity {

    ImageView imgBackAppbar;
    TextView tvTitle, tvNamaBarang, tvKodeBarang, tvHargaJual, tvStok, tvKeterangan;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        // ---------- APP BAR TITLE ---------- //
        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Daftar Barang");


        // ---------- Set Status Bar Color ---------- //
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.status_bar_color));
        Objects.requireNonNull(getSupportActionBar()).hide();


        // ---------- APPBAR BACK BUTTON ---------- //
        imgBackAppbar = findViewById(R.id.imgBack);
        imgBackAppbar.setVisibility(View.VISIBLE);
        imgBackAppbar.setOnClickListener(v -> {
            Intent intent = new Intent(DetailBarangActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            getWindow().setEnterTransition(new Slide());
        });

        // --------- INITIALIZATION OF VIEW ------------ //

        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        tvNamaBarang.setText(getIntent().getStringExtra("nama"));

        tvKodeBarang = findViewById(R.id.tvKodeBarang);
        tvKodeBarang.setText(getIntent().getStringExtra("kode"));

        tvHargaJual = findViewById(R.id.tvHargaJual);
        int harga = Integer.parseInt(getIntent().getStringExtra("harga"));
        String hargaText = "Rp. " + harga;
        tvHargaJual.setText(hargaText);

        tvStok = findViewById(R.id.tvStok);
        int stok = Integer.parseInt(getIntent().getStringExtra("stok"));
        String stokText = stok + " item";
        tvStok.setText(stokText);

        tvKeterangan = findViewById(R.id.tvKeterangan);
        tvKeterangan.setText(getIntent().getStringExtra("keterangan"));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetailBarangActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        getWindow().setEnterTransition(new Fade());
    }
}
