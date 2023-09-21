package com.example.fullcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView primaryTextViewObj;
    TextView seconderyTextViewObj;
    Button numberBtnObj;
    Button operatorBtnObj;
    String primaryValue;
    String secondaryValue;
    String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primaryTextViewObj = findViewById(R.id.primaryTextViewID);
        seconderyTextViewObj = findViewById(R.id.seconderyTextViewID);
    }

    public void numericFunction(View view) {
        numberBtnObj=findViewById(view.getId());
        String btnValue = numberBtnObj.getText().toString();

        String tempPrimaryValue = primaryTextViewObj.getText().toString();
        if(tempPrimaryValue.equals("0")){
            primaryTextViewObj.setText(btnValue);
        }
        else {
            primaryTextViewObj.setText(tempPrimaryValue+btnValue);

        }
    }

    public void clearFunction(View view) {
        primaryTextViewObj.setText("0");
        seconderyTextViewObj.setText("");
    }

    public void operatorFunction(View view) {
    primaryValue = primaryTextViewObj.getText().toString();

    operatorBtnObj = findViewById(view.getId());
    operator = operatorBtnObj.getText().toString();

    seconderyTextViewObj.setText(primaryValue + " " + operator);
    primaryTextViewObj.setText("0");
    }

    public void resultFunction(View view) {
        secondaryValue = primaryTextViewObj.getText().toString();
        Double num1, num2, result;
        num1 = Double.parseDouble(primaryValue);
        num2 = Double.parseDouble(secondaryValue);
        if(operator.equals("+")){
            result = num1 + num2;
        }
        else if(operator.equals("-")){
            result = num1 - num2;
        }
        else if(operator.equals("x")){
            result = num1 * num2;
        }
        else {
            result = num1 / num2;
        }
        seconderyTextViewObj.setText(primaryValue + " " + operator + " " + secondaryValue);

        primaryTextViewObj.setText("" + result);
    }
}