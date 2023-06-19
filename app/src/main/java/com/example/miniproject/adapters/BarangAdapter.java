package com.example.miniproject.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject.room.Barang;
import com.example.miniproject.DetailBarangActivity;
import com.example.miniproject.R;

import java.util.ArrayList;
import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {

    List<Barang> barangs = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{

//        ImageView IVBarang;
        ImageView IVNext;
        TextView TVNamaBarang;
        TextView TVKodeBarang;
        TextView TVHargaBarang;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            IVBarang = itemView.findViewById(R.id.IVBarang);
            IVNext = itemView.findViewById(R.id.IVNext);
            TVNamaBarang = itemView.findViewById(R.id.TVNamaBarang);
            TVKodeBarang = itemView.findViewById(R.id.TVKodeBarang);
            TVHargaBarang = itemView.findViewById(R.id.TVHargaBarang);
        }
    }

    @NonNull
    @Override
    public BarangAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.ViewHolder holder, int position) {
        Barang currentBarang = barangs.get(position);
        holder.TVNamaBarang.setText(currentBarang.getNama());
        holder.TVKodeBarang.setText(currentBarang.getKode());
        holder.TVHargaBarang.setText(String.valueOf(currentBarang.getHarga()));
        holder.IVNext.setOnClickListener(v1 -> {
            Intent intent = new Intent(v1.getContext(), DetailBarangActivity.class);
            intent.putExtra("nama", currentBarang.getNama());
            intent.putExtra("kode", currentBarang.getKode());
            intent.putExtra("harga", String.valueOf(currentBarang.getHarga()));
            intent.putExtra("stok", String.valueOf(currentBarang.getStok()));
            intent.putExtra("keterangan", currentBarang.getKeterangan());
            v1.getContext().startActivity(intent);
        });

    }

    public void setBarangs(List<Barang> barangs) {
        this.barangs.clear(); // Clear the previous data
        this.barangs.addAll(barangs); // Add the new data
        notifyDataSetChanged(); // Notify the adapter that the data has changed
    }


    @Override
    public int getItemCount() {
        return barangs.size();
    }
}
