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

public class editSewa extends AppCompatActivity {
    EditText nama, nama_camera, harga, tanggal_sewa, tanggal_kembali;
    Button btnedit;
    sqlSewa dbHelper;
    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sewa);

        dbHelper = new sqlSewa(this);
        nama = (EditText)findViewById(R.id.nama);
        nama_camera = (EditText)findViewById(R.id.nama_camera);
        harga = (EditText)findViewById(R.id.harga);
        tanggal_sewa = (EditText)findViewById(R.id.tanggal_sewa);
        tanggal_kembali = (EditText)findViewById(R.id.tanggal_kembali);
        btnedit = (Button)findViewById(R.id.btnedit);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * from sewa where nama = '"+ getIntent().getStringExtra("nama") +"'";
        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            nama.setText(cursor.getString(1).toString());
            nama_camera.setText(cursor.getString(2).toString());
            harga.setText(cursor.getString(3).toString());
            tanggal_sewa.setText(cursor.getString(4).toString());
            tanggal_kembali.setText(cursor.getString(5).toString());
        }
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "UPDATE sewa SET nama = '"+ nama.getText().toString() +"',"+
                        "nama_camera      = '"+ nama_camera.getText().toString() +"',"+
                        "harga      = '"+ harga.getText().toString() +"',"+
                        "tanggal_sewa      = '"+ tanggal_sewa.getText().toString() +"',"+
                        "tanggal_kembali     = '"+ tanggal_kembali.getText().toString() +"'"+
                        "WHERE nama = '"+ getIntent().getStringExtra("nama")+"'";

                db.execSQL(sql);
                Toast.makeText(getApplicationContext(), "Berhasil Mengubah Data", Toast.LENGTH_LONG).show();
                crud2.bd.RefreshList();
                finish();
            }
        });
    }
    public void onclickBack(View arg0) {
        Intent ExplicitIntent=new Intent(editSewa.this, crud2.class);
        startActivity(ExplicitIntent);
    }
}
