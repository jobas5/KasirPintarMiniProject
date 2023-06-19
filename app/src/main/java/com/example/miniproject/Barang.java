package com.example.miniproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_barang")
public class Barang {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String kode;
    private final String nama;
    private final int harga;
    private final int stok;
    private final String keterangan;

    public Barang(String kode, String nama, int harga, int stok, String keterangan) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        this.keterangan = keterangan;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
    public String getKode(){
        return kode;
    }

    public String getNama(){
        return nama;
    }

    public int getHarga(){
        return harga;
    }

    public int getStok(){
        return stok;
    }

    public String getKeterangan(){
        return keterangan;
    }

}
