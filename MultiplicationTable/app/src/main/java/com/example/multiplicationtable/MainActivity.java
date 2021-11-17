package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText number;
    TextView table;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        number = findViewById(R.id.number);
        table = findViewById(R.id.textView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(number.getText().toString());
//                StringBuffer buffer = new StringBuffer();
//                int ans;
                for(int i=1;i<=10;i++){
//                    ans = (i * n);
//                    buffer.append(n + " X " + i
//                            + " = " + ans + "\n\n");
                    table.append(n+"X"+i+"="+n*i+"\n\n");
                }
//                table.setText(buffer);
//                Toast.makeText(MainActivity.this, buffer, Toast.LENGTH_SHORT).show();
            }
        });
    }
}