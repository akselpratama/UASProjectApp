package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class detailSewa extends AppCompatActivity {
    TextView nama, nama_camera, harga, tanggal_sewa, tanggal_kembali;
    sqlSewa dbHelper;
    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sewa);

        dbHelper = new sqlSewa(this);
        nama = (TextView) findViewById(R.id.nama);
        nama_camera = (TextView)findViewById(R.id.nama_camera);
        harga = (TextView) findViewById(R.id.harga);
        tanggal_sewa = (TextView)findViewById(R.id.tanggal_sewa);
        tanggal_kembali = (TextView)findViewById(R.id.tanggal_kembali);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sqlSewa = "SELECT * from sewa where nama = '"+ getIntent().getStringExtra("nama") +"'";
        cursor = db.rawQuery(sqlSewa, null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(1).toString());
            nama_camera.setText(cursor.getString(2).toString());
            harga.setText(cursor.getString(3).toString());
            tanggal_sewa.setText(cursor.getString(4).toString());
            tanggal_kembali.setText(cursor.getString(5).toString());
        }
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(detailSewa.this, crud2.class);
        startActivity(ExplicitIntent);
    }
}
