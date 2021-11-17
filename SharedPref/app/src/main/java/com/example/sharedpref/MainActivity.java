package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String editVal = sp.getString("name", "no_value");
        textView.setText(editVal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();
                SharedPreferences sp = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                ed.putString("name",val);
                ed.apply();
                textView.setText(val);
            }
        });
    }
}