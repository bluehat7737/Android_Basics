package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String [] questions = {"Java is Fully Object Oriented", "Java is Invented in 1992",
            "Java is used to develop android Apps", "Java is a Person", "Java is used to develop IOS Apps"};
    private Boolean [] answers = {false, false, true, false, false};
    Button yes;
    Button no;
    TextView question;
    int score = 0;
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.textView);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index>=questions.length){
                    Toast.makeText(MainActivity.this, "Your Score is "+score, Toast.LENGTH_SHORT).show();
                }
                else{
                    if(index<answers.length && answers[index]){
                        score++;
                    }
                    question.setText(questions[index]);
                    index++;
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index>=questions.length){
                    Toast.makeText(MainActivity.this, "Your Score is "+score, Toast.LENGTH_SHORT).show();
                }
                else{
                    if(index<answers.length && !answers[index]){
                        score++;
                    }
                    question.setText(questions[index]);
                    index++;
                }
            }
        });
    }
}