package com.example.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Contact a = new Contact(1, "Anshul", "1234567890");
    Contact b = new Contact(1, "Aryan", "1234567890");
    Contact c = new Contact(1, "Harshit", "1234567890");
    Contact d = new Contact(1, "Rohan", "1234567890");
    Contact e = new Contact(1, "Harsh", "1234567890");
    Contact f = new Contact(1, "Saksham", "1234567890");
    Contact g = new Contact(1, "Nihal", "1234567890");
    Contact [] contacts = {a,b,c,d,e,f,g};

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter ad = new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}