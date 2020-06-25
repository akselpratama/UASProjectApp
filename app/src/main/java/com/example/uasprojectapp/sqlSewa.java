package com.example.uasprojectapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqlSewa extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="sewa.db";
    private static final int DATABASE_VERSION=1;

    public sqlSewa(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table sewa (id integer primary key autoincrement," +
                "                          nama text null," +
                "                          nama_camera text null," +
                "                          harga text null," +
                "                          tanggal_sewa text null," +
                "                          tanggal_kembali text null);";
        Log.d("Data","OnCreate:" +sql);
        db.execSQL(sql);
        sql ="INSERT INTO sewa(id,nama,nama_camera,harga,tanggal_sewa,tanggal_kembali)" +
                "         VALUES(001,'Anya Geraldine','Canon EOS 6D','350000','01-06-2020','02-06-2020');";
        db.execSQL(sql);
        sql ="INSERT INTO sewa(id,nama,nama_camera,harga,tanggal_sewa,tanggal_kembali)" +
                "         VALUES(002,'Yoki Kato','Canon EOS 5D','300000','05-06-2020','06-06-2020');";
        db.execSQL(sql);
        sql ="INSERT INTO sewa(id,nama,nama_camera,harga,tanggal_sewa,tanggal_kembali)" +
                "         VALUES(003,'Aurelie','Canon EOS M3','150000','04-06-2020','05-06-2020');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
