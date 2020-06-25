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

public class detailCamera extends AppCompatActivity {
    TextView  namacamera, harga, stok;
    sqlCamera dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_camera);

        dbHelper = new sqlCamera(this);
        namacamera = (TextView) findViewById(R.id.namacamera);
        harga = (TextView) findViewById(R.id.harga);
        stok = (TextView) findViewById(R.id.stok);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sqlCamera = "SELECT * from camera where nama_camera = '"+ getIntent().getStringExtra("nama_camera") +"'";
        cursor = db.rawQuery(sqlCamera, null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            namacamera.setText(cursor.getString(1).toString());
            harga.setText(cursor.getString(2).toString());
            stok.setText(cursor.getString(3).toString());
        }
    }

    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(detailCamera.this, crud1.class);
        startActivity(ExplicitIntent);
    }
}
