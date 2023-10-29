package com.example.mobilecalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String opereator;
    String oldNumber;
    Boolean isNew = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }


    public void clickNumber(View view) {
        if (isNew) {
            editText.setText("");
            isNew = false;
        }
        String number = editText.getText().toString();
        if (view.getId() == R.id.bu0) {
            number = number + "0";
        } else if (view.getId() == R.id.bu1) {
            number = number + "1";
        } else if (view.getId() == R.id.bu2) {
            number = number + "2";
        } else if (view.getId() == R.id.bu3) {
            number = number + "3";
        } else if (view.getId() == R.id.bu4) {
            number = number + "4";
        } else if (view.getId() == R.id.bu5) {
            number = number + "5";
        } else if (view.getId() == R.id.bu6) {
            number = number + "6";
        } else if (view.getId() == R.id.bu7) {
            number = number + "7";
        } else if (view.getId() == R.id.bu8) {
            number = number + "8";
        } else if (view.getId() == R.id.bu9) {
            number = number + "9";
        } else if (view.getId() == R.id.buDot) {
            number = number + ".";
        } else if (view.getId() == R.id.buPlusMinus) {
            number = "-" + number;
        }
        editText.setText(number);
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();
        if (view.getId() == R.id.buMinus) {
            opereator = "-";
        } else if (view.getId() == R.id.buPlus) {
            opereator = "+";
        } else if (view.getId() == R.id.buDivide) {
            opereator = "/";
        } else if (view.getId() == R.id.buMultiply) {
            opereator = "*";
        }
    }
}