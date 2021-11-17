package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] items = {"Anshul", "Harshit", "Aryan", "Rohan", "Prabhat", "Dipak", "Sameer"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
//        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
//        listView.setAdapter(ad);

        AnshulAdapter ad = new AnshulAdapter(this, R.layout.my_anshul_layout, items);
        listView.setAdapter(ad);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "You clicked on "+ i, Toast.LENGTH_SHORT).show();
                final Toast toast = Toast.makeText(getApplicationContext(), "You Clicked on "+i, Toast.LENGTH_SHORT);
                toast.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 200);
            }
        });
    }
}