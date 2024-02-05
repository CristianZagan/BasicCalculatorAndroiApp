package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText firstNumber;
    private EditText secondNumber;
    private RadioGroup operators;
    private RadioButton add;
    private RadioButton subtract;
    private RadioButton multiply;
    private RadioButton divide;
    private Button equals;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Main Activity");
        getWindow().getDecorView().setBackgroundColor(0x66000000);

        firstNumber = findViewById(R.id.number1);
        secondNumber = findViewById(R.id.number2);
        operators = findViewById(R.id.radioGroup);
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        result = findViewById(R.id.result);

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstNumberText = firstNumber.getText().toString();
                String secondNumberText = secondNumber.getText().toString();

                if (firstNumberText.isEmpty() || secondNumberText.isEmpty()) {
                    result.setText("Please select numbers");
                    return;
                }

                double firstNumberValue = Double.parseDouble(firstNumber.getText().toString());
                double secondNumberValue = Double.parseDouble(secondNumber.getText().toString());



                int operationButtonId = operators.getCheckedRadioButtonId();

                double answer;
                if (operationButtonId == add.getId()) {
                    answer = firstNumberValue + secondNumberValue;
                } else if (operationButtonId == subtract.getId()) {
                    answer = firstNumberValue - secondNumberValue;
                } else if (operationButtonId == multiply.getId()) {
                    answer = firstNumberValue * secondNumberValue;
                } else if (operationButtonId == divide.getId()) {
                    if (secondNumberValue == 0) {
                        result.setText("Cannot divide by zero");
                        return;
                    }
                    answer = firstNumberValue / secondNumberValue;
                } else {
                    result.setText("Please select an operation");
                    return;
                }

                if (answer == (int) answer) {
                    result.setText(String.valueOf((int) answer));
                } else {
                    result.setText(String.valueOf(answer));
                }

            }
        });
    }
}
