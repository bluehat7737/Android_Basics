package com.example.coffeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView quantity;
    TextView price;
//    String k = (String) quantity.getText();
    int quantityNumber = 2;
    private static final String TAG = "Anshul";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantity = findViewById(R.id.quantity_text_view);
        price = findViewById(R.id.price_text_view);
    }

    public void increment(View view){
        if(quantityNumber<10){
            quantity.setText(String.valueOf(quantityNumber+1));
            quantityNumber++;
        }
        Log.d(TAG, "increment: ok");
    }

    public void decrement(View view){
        if(quantityNumber>1){
            quantity.setText(String.valueOf(quantityNumber-1));
            quantityNumber--;
        }
        Log.d(TAG, "decrement: ok");
    }

    public void submitOrder(View view){
        if(quantityNumber>=1){
            price.setText("Total: $"+String.valueOf(quantityNumber*5) + "\nThank You!");
        }
        Log.d(TAG, "submitOrder: ok");
    }
}