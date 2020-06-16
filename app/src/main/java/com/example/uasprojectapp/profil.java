package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class profil extends AppCompatActivity {
    TextView textuser;
    SharedPreference sp;
    Activity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        sp = new SharedPreference();
        textuser=(TextView) findViewById(R.id.txtuserprofile);
        String username;
        username= sp.getValue(context, "username");

        textuser.setText(username);
    }
}

