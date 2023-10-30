package com.example.mobilecalculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String operator = "";
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
            if (dotIsPresent(number)) {
            } else {
                number = number + ".";
            }
        } else if (view.getId() == R.id.buPlusMinus) {
            if (minusIsPresent(number)) {
                number = number.substring(1);
            } else {
                number = "-" + number;
            }
        }
        editText.setText(number);
    }

    public boolean minusIsPresent(String number) {
        if (number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    public void operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();
        if (view.getId() == R.id.buMinus) {
            operator = "-";
        } else if (view.getId() == R.id.buPlus) {
            operator = "+";
        } else if (view.getId() == R.id.buDivide) {
            operator = "/";
        } else if (view.getId() == R.id.buMultiply) {
            operator = "*";
        }
    }

    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        editText.setText(result + "");
    }

    public void acClick(View view) {
        editText.setText("0");
        isNew = true;
    }

    public boolean dotIsPresent(String number) {
        if (number.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void clickPercent(View view) {
        if (operator == "") {
            String number = editText.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp + "";
            editText.setText(number);
        } else {
            Double result = 0.0;
            String newNumber = editText.getText().toString();
            switch (operator) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100;
                    break;
            }
            editText.setText(result + "");
            operator = "";
        }
    }
}