package com.example.miniproject.room;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Barang.class}, version = 1)
public abstract class BarangDatabase extends RoomDatabase {

    public abstract BarangDao barangDao();

    private static volatile BarangDatabase instance;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized BarangDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            BarangDatabase.class, "barang_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                BarangDao barangDao = instance.barangDao();
                populateDatabase(barangDao);
                Log.d("BarangDatabase", "Database populated");
            });
        }
    };



    private static void populateDatabase(BarangDao barangDao) {
        barangDao.insert(new Barang("tcpr0044", "Burger Ayam Pedas", 35000, 10, "Burger enak rasanya bikin nagih"));
        barangDao.insert(new Barang("tcmm0053", "Pizza Keju", 10000, 7, "Pizza Keju enak rasanya kejunya full"));
        barangDao.insert(new Barang("8992510090706", "Donat", 15000, 20, "Donat dengan banyak rasa"));
        barangDao.insert(new Barang("8888900415009", "Spaghetti", 25000, 15, "Spaghetti rasanya gurih"));
    }
}
