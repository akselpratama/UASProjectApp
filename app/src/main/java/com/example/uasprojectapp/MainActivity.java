package com.example.uasprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    private EditText emailEditText;
    private EditText passEditText;
    Button button;
    private SharedPreference sp;
    Activity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SharedPreference();
        button=(Button)findViewById(R.id.btnlogin);

        emailEditText =(EditText)findViewById(R.id.txtusername);
        passEditText =(EditText)findViewById(R.id.txtpassword);
    }
    public void checklogin(View v) {
        final String email = emailEditText.getText().toString();
        switch (v.getId()) {
            case R.id.btnlogin:
                hideKeybaord(v);
                break;
        }
        if (!isValidEmail(email)) {
            emailEditText.setError("Username Salah !");
        }
        final String pass = passEditText.getText().toString();
        if (!isValidPassword(pass)) {
            passEditText.setError("Password Salah !");
        }
        if (isValidEmail(email) && isValidPassword(pass)) {
            sp.save(context, "username", email);
            Toast.makeText(getApplicationContext(), "Anda berhasil login ",Toast.LENGTH_LONG).show();
            Intent ExplicitIntent=new Intent(MainActivity.this, menu.class);
            startActivity(ExplicitIntent);
        }
    }
    private void hideKeybaord(View v) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
    }

    public boolean isValidPassword (String password) {
        if (password != null && password.equals("18101057")) {
            return true;
        }
        return false;
    }

    public boolean isValidEmail(String username) {
        if (username != null && username.equals("18101057")) {
            return true;
        }
        return false;
    }
}
