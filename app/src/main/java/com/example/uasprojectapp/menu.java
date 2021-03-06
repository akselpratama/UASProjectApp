package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class menu extends AppCompatActivity {
    Button button;
    CardView btnprofil, btncrud1, btncrud2;
    SharedPreference sp;
    Activity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnprofil=(CardView) findViewById(R.id.btnprofil);
        btncrud1=(CardView) findViewById(R.id.btncrud1);
        btncrud2=(CardView) findViewById(R.id.btncrud2);
        button=(Button)findViewById(R.id.btnkeluar);
        sp = new SharedPreference();
    }
    public void onclickprofil(View arg0) {
        Toast.makeText(getApplicationContext(), "Selamat Datang di Profil Saya ",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, profil.class);
        startActivity(ExplicitIntent);
    }
    public void oncliccrud1(View arg0) {
        Toast.makeText(getApplicationContext(), "Selamat Datang di Data Camera ",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, crud1.class);
        startActivity(ExplicitIntent);
    }
    public void onclickcrud2(View arg0) {
        Toast.makeText(getApplicationContext(), "Selamat Datang di Data Sewa ",Toast.LENGTH_LONG).show();
        Intent ExplicitIntent=new Intent(menu.this, crud2.class);
        startActivity(ExplicitIntent);
    }
    public void onclickkeluar(View arg0) {
        Toast.makeText(getApplicationContext(), "Anda Berhasil Keluar ",Toast.LENGTH_LONG).show();
        sp.clearSharedPreference(context);
        finish();
    }
}