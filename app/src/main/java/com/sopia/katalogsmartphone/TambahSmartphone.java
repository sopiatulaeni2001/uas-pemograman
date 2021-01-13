package com.sopia.katalogsmartphone;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class TambahSmartphone extends AppCompatActivity {
    protected Cursor cursor;
    Datas dbHelper;
    FloatingActionButton ton1, ton2;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_smartphone);

        dbHelper = new Datas(this);

        text2 = (EditText) findViewById(R.id.editText2);

        ton1 = (FloatingActionButton) findViewById(R.id.button1);
        ton2 = (FloatingActionButton) findViewById(R.id.button2);

        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into namephone(model) values('" +
                        text2.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}