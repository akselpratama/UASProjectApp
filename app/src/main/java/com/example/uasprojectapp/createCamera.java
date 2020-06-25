package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createCamera extends AppCompatActivity {
    sqlCamera dbHelper;
    Button btntambah;
    EditText namacamera, harga, stok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_camera);

        dbHelper =new sqlCamera(this);
        namacamera = (EditText)findViewById(R.id.namacamera);
        harga = (EditText)findViewById(R.id.harga);
        stok = (EditText)findViewById(R.id.stok);
        btntambah = (Button)findViewById(R.id.btntambah);

        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "INSERT INTO camera (nama_camera, harga, stok)" +
                        "     VALUES ('"+ namacamera.getText().toString() +"'," +
                        "             '"+ harga.getText().toString() +"'," +
                        "             '"+ stok.getText().toString() +"')";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(),"Berhasil Menambahkan Data", Toast.LENGTH_LONG).show();
                crud1.bd.RefreshList();
                finish();
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(createCamera.this, crud1.class);
        startActivity(ExplicitIntent);
    }
}
