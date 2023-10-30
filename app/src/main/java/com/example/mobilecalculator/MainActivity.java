package com.example.mobilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    String operator = "";
    String oldNumber;
    Boolean isNew = true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        mediaPlayer = MediaPlayer.create(this, R.raw.click_sound);
    }

    public void clickNumber(View view) {
        mediaPlayer.start();
        if (isNew) {
            editText.setText("");
            isNew = false;
        }
        String number = editText.getText().toString();
        if (view.getId() == R.id.bu0) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = "0";
            } else {
                number = number + "0";
            }
        } else if (view.getId() == R.id.bu1) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "1";
        } else if (view.getId() == R.id.bu2) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "2";
        } else if (view.getId() == R.id.bu3) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "3";
        } else if (view.getId() == R.id.bu4) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "4";
        } else if (view.getId() == R.id.bu5) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "5";
        } else if (view.getId() == R.id.bu6) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "6";
        } else if (view.getId() == R.id.bu7) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "7";
        } else if (view.getId() == R.id.bu8) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "8";
        } else if (view.getId() == R.id.bu9) {
            if (zeroIsFirst(number) && number.length() == 1) {
                number = number.substring(1);
            }
            number = number + "9";
        } else if (view.getId() == R.id.buDot) {
            if (dotIsPresent(number)) {
            }
            if (zeroIsFirst(number)) {
                number = "0.";
            } else {
                number = number + ".";
            }
        } else if (view.getId() == R.id.buPlusMinus) {
            if (numberIsZero(number)) {
                number = "0";
            } else {
                if (minusIsPresent(number)) {
                    number = number.substring(1);
                } else {
                    number = "-" + number;
                }
            }
        }
        editText.setText(number);
    }

    private boolean zeroIsFirst(String number) {
        if (number.equals("")) {
            return true;
        }
        if (number.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }

    private boolean numberIsZero(String number) {
        if (number.equals("0") || number.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean minusIsPresent(String number) {
        if (number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    public void operation(View view) {
        mediaPlayer.start();
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
        mediaPlayer.start();
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
        mediaPlayer.start();
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
        mediaPlayer.start();
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