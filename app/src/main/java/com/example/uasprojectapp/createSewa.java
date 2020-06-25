package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createSewa extends AppCompatActivity {
    sqlSewa dbHelper;
    Button btntambah;
    EditText nama, nama_camera, harga, tanggal_sewa, tanggal_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_sewa);

        dbHelper =new sqlSewa(this);
        nama = (EditText)findViewById(R.id.nama);
        nama_camera = (EditText)findViewById(R.id.nama_camera);
        harga = (EditText)findViewById(R.id.harga);
        tanggal_sewa = (EditText)findViewById(R.id.tanggal_sewa);
        tanggal_kembali = (EditText)findViewById(R.id.tanggal_kembali);
        btntambah = (Button)findViewById(R.id.btntambah);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "INSERT INTO sewa (nama, nama_camera, harga, tanggal_sewa, tanggal_kembali)" +
                        "     VALUES ('"+ nama.getText().toString() +"'," +
                        "             '"+ nama_camera.getText().toString() +"'," +
                        "             '"+ harga.getText().toString() +"'," +
                        "             '"+ tanggal_sewa.getText().toString() +"'," +
                        "             '"+ tanggal_kembali.getText().toString() +"')";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(),"Berhasil Tambah Data", Toast.LENGTH_LONG).show();
                crud2.bd.RefreshList();
                finish();
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(createSewa.this, crud2.class);
        startActivity(ExplicitIntent);
    }
}
