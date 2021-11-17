package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler handler = new DBHandler(this, "empd", null, 1);
//        handler.addEmployee(new Employee(1, "Anshul", 33.3));
        handler.getEmployee(1);
        handler.close();
    }
}