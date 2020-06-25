package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editCamera extends AppCompatActivity {
    EditText namacamera, harga, stok;
    Button btnedit;
    sqlCamera dbHelper;
    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_camera);

        dbHelper = new sqlCamera(this);
        namacamera = (EditText)findViewById(R.id.namacamera);
        harga = (EditText)findViewById(R.id.harga);
        stok = (EditText)findViewById(R.id.stok);
        btnedit = (Button)findViewById(R.id.btnedit);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * from camera where nama_camera = '"+ getIntent().getStringExtra("nama_camera") +"'";
        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            namacamera.setText(cursor.getString(1).toString());
            harga.setText(cursor.getString(2).toString());
            stok.setText(cursor.getString(3).toString());
        }
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "UPDATE camera SET nama_camera = '"+ namacamera.getText().toString() +"',"+
                        "harga      = '"+ harga.getText().toString() +"',"+
                        "stok     = '"+ stok.getText().toString() +"'"+
                        "WHERE nama_camera = '"+ getIntent().getStringExtra("nama_camera")+"'";

                db.execSQL(sql);
                Toast.makeText(getApplicationContext(), "Berhasil Mengubah Data", Toast.LENGTH_LONG).show();
                crud1.bd.RefreshList();
                finish();
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(editCamera.this, crud1.class);
        startActivity(ExplicitIntent);
    }
}
