package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    private Double operand1 = null;
    private String pendingOperation = "=";
    public static final String OPERAND = "operand";
    public static final String OPERATOR = "operator";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        newNumber = findViewById(R.id.newNumber);
        displayOperation = findViewById(R.id.operation);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button addition = findViewById(R.id.addition);
        Button subtraction = findViewById(R.id.subtraction);
        Button divide = findViewById(R.id.divide);
        Button multiply = findViewById(R.id.multiply);
        Button dot = findViewById(R.id.dot);
        Button equals = findViewById(R.id.equals);
        Button negative = findViewById(R.id.negative);
        Button clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newNumber.setText("");
                result.setText("");
                displayOperation.setText("");
                operand1 = null;
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                newNumber.append(b.getText().toString());
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        dot.setOnClickListener(listener);

//        Button [] numbers = {button0,button1,button2,button3,button4,button5,button6,button7,button8,button9};

        View.OnClickListener negListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = newNumber.getText().toString();
                if(newNumber.length() == 0){
                    newNumber.setText("-");
                }else{
                    try{
                        Double doubleValue = Double.valueOf(value);
                        doubleValue *= -1;
                        newNumber.setText(doubleValue.toString());
                    }
                    catch (NumberFormatException e){
                        newNumber.setText("");
                    }
                }
            }
        };

        negative.setOnClickListener(negListener);

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();
//                if(op.equals("-")){
//                    for(Button num: numbers){
//                        num.setOnClickListener(negListener);
//                    }
//                }
                    try {
                        Double doubleValue = Double.valueOf(value);
                        performOperations(doubleValue, op);
                    }
                    catch (NumberFormatException e){
                        newNumber.setText("");
                    }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };

        addition.setOnClickListener(opListener);
        subtraction.setOnClickListener(opListener);
        multiply.setOnClickListener(opListener);
        divide.setOnClickListener(opListener);
        equals.setOnClickListener(opListener);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if(operand1!=null){
            outState.putDouble(OPERAND, operand1);
        }
        outState.putString(OPERATOR, pendingOperation);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOperation = savedInstanceState.getString(OPERATOR);
        operand1 = savedInstanceState.getDouble(OPERAND);
        displayOperation.setText(pendingOperation);
    }

    @SuppressLint("SetTextI18n")
    private void performOperations(Double value, String operation){
        if(null == operand1){
            operand1 = value;
        }
        else{
            if(pendingOperation.equals("=")){
                pendingOperation = operation;
            }
            switch (pendingOperation){
                case "=":
                    operand1 = value;
                    break;
                case "/":
                    if(value == 0){
                        operand1 = 0.0;
                    }
                    else{
                        operand1 /= value;
                    }
                    break;
                case "*":
                    operand1 *= value;
                    break;
                case "+":
                    operand1 += value;
                    break;
                case "-":
                    operand1 -= value ;
                    break;
            }
        }

        result.setText(operand1.toString());
        newNumber.setText("");
    }
}