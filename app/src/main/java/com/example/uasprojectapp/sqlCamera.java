package com.example.uasprojectapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sqlCamera extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="camera.db";
    private static final int DATABASE_VERSION=1;

    public sqlCamera(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table camera (id integer primary key autoincrement," +
                "                          nama_camera text null," +
                "                          harga text null," +
                "                          stok text null);";
        Log.d("Data","OnCreate:" +sql);
        db.execSQL(sql);
        sql ="INSERT INTO camera(id,nama_camera,harga,stok)" +
                "         VALUES(001,'Canon EOS 6D','350000','5');";
        db.execSQL(sql);
        sql ="INSERT INTO camera(id,nama_camera,harga,stok)" +
                "         VALUES(002,'Canon EOS 5D MkII','30000','4');";
        db.execSQL(sql);
        sql ="INSERT INTO camera(id,nama_camera,harga,stok)" +
                "         VALUES(003,'Canon EOS M3','150000','7');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
