package com.example.twonumberadd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText numberone;
    EditText numbertwo;
    Button button;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberone = findViewById(R.id.numberone);
        numbertwo = findViewById(R.id.numbertwo);
        button = findViewById(R.id.button);
        result = findViewById(R.id.result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ns1 = numberone.getText().toString();
                String ns2 = numbertwo.getText().toString();
                int n1 = Integer.parseInt(ns1);
                int n2 = Integer.parseInt(ns2);
                int r = n1+n2;
                result.setText("Sum = "+r);
            }
        });
    }
}