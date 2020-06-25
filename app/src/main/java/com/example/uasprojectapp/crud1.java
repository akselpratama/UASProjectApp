package com.example.uasprojectapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

public class crud1 extends AppCompatActivity {
    String[] daftar;
    ListView datacamera;
    sqlCamera dbHelper;
    Menu menu;
    protected Cursor cursor;
    public static crud1 bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud1);
        bd = this;
        dbHelper = new sqlCamera(this);
      RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("Select * FROM camera", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }

        datacamera = (ListView) findViewById(R.id.datacamera);
        datacamera.setAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, daftar));
        datacamera.setSelected(true);
        ((ArrayAdapter)datacamera.getAdapter()).notifyDataSetInvalidated();

        datacamera.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Edit","Detail","Delete "};
                AlertDialog.Builder builder = new AlertDialog.Builder(crud1.this);
                builder.setTitle("Pilih!");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent intent = new Intent(crud1.this,editCamera.class);
                                intent.putExtra("nama_camera", selection);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(crud1.this, detailCamera.class);
                                intent.putExtra("nama_camera", selection);
                                startActivity(intent);
                                break;
                            case 2:
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                String sql = "DELETE from camera where nama_camera='"+ selection +"'";
                                db.execSQL(sql);
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        this.menu = menu;
        menu.add(0, 1, 0, "Tambah");
        menu.add(0, 2, 0, "Refresh");
        menu.add(0, 3, 0, "Exit");
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(crud1.this,createCamera.class);
                startActivity(intent);
                return true;
            case 2:
                RefreshList();
                return true;
            case 3:
                onclickBack();
                return true;
        }
        return false;
    }
    public void onclickBack() {
        Intent ExplicitIntent=new Intent(crud1.this, menu.class);
        startActivity(ExplicitIntent);
    }
}
