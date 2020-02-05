package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button buttonZero;
    Button btnAdd;
    Button buttonMultiply;
    Button buttonSubtraction;
    Button buttonDivide;
    Button buttonEqual;
    Button btnClearBtn;

    String lastElement="";
    String inputValue = "";
    TextView textViewResult;
    TextView textViewShowResult;
    String operator = "";
    Double num1 ;
    Double num2 ;
    Double result;
    Double numberPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();

    }

    private void initControl() {
        btnSeven = findViewById(R.id.button7);
        btnEight = findViewById(R.id.button8);
        btnNine = findViewById(R.id.button9);
        btnFour = findViewById(R.id.button4);
        btnFive = findViewById(R.id.button5);
        btnSix = findViewById(R.id.button6);
        btnOne = findViewById(R.id.button1);
        btnTwo = findViewById(R.id.button2);
        btnThree = findViewById(R.id.button3);
        buttonZero = findViewById(R.id.buttonZero);

        btnClearBtn = findViewById(R.id.btnClearBtn);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        btnAdd = findViewById(R.id.buttonAdd);
        buttonSubtraction = findViewById(R.id.buttonSubtraction);
        buttonEqual = findViewById(R.id.buttonEqual);


        btnSeven.setOnClickListener((View.OnClickListener) this);
        btnEight.setOnClickListener((View.OnClickListener) this);
        btnNine.setOnClickListener((View.OnClickListener) this);
        btnFour.setOnClickListener((View.OnClickListener) this);
        btnFive.setOnClickListener((View.OnClickListener) this);
        btnSix.setOnClickListener((View.OnClickListener) this);
        btnOne.setOnClickListener((View.OnClickListener) this);
        btnTwo.setOnClickListener((View.OnClickListener) this);

        btnThree.setOnClickListener((View.OnClickListener) this);
        btnAdd.setOnClickListener( (View.OnClickListener) this);
        buttonSubtraction.setOnClickListener((View.OnClickListener)this);
        btnClearBtn.setOnClickListener((View.OnClickListener)this);
        buttonMultiply.setOnClickListener((View.OnClickListener) this);
        buttonDivide.setOnClickListener((View.OnClickListener) this);
        buttonEqual.setOnClickListener((View.OnClickListener) this);


        textViewResult = findViewById(R.id.textView1);
        textViewShowResult = findViewById(R.id.textView2);


    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.button7:
                inputValue += "7";
                numberPressed = 7.0;
                doMathOperation(operator, inputValue);
                break;
            case R.id.button8:
                Log.i("BTNCLICK", "clicked");
                inputValue += "8";
                numberPressed = 8.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.button9:
                inputValue += "9";
                numberPressed = 9.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.button4:
                inputValue += "4";
                numberPressed = 4.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.button5:
                inputValue += "5";
                numberPressed = 5.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.button1:
                inputValue += "1";
                numberPressed = 1.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.button2:
                inputValue += "2";
                numberPressed = 2.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.button3:
                inputValue += "3";
                numberPressed = 3.0;
                doMathOperation(operator, inputValue);
                break;
            case  R.id.buttonZero:
                inputValue += "0";
                numberPressed = 0.0;
                doMathOperation(operator, inputValue);
                break;
            case R.id.buttonSubtraction:
                Log.i("BTNSUBT", "subtract button clicked");
                operator = "-";
                operatorPressed(operator);

                break;
            case R.id.btnClearBtn:
                operator = "";
                inputValue = "";
                num1 = 0.0;
                num2 = 0.0;
                result = 0.0;
                textViewShowResult.setText("");


                break;
            case  R.id.buttonMultiply:
                operator = "*";
                operatorPressed(operator);

                break;
                /*divide*/
            case  R.id.buttonDivide:
                operator = "/";
                operatorPressed(operator);
                break;


            case R.id.buttonAdd:
                Log.i("ADDBTN", "Add button clicked");
                operator = "+";


                operatorPressed(operator);
                break;


        }
        updateResultTextView(inputValue);

    }

    private void doMathOperation(String operator, String numberPressed) {
        if(checkIfOperatorPressed(operator)){
            if(operator.equals("+")){
                num2 = Double.parseDouble(numberPressed);

                result =  num1 + num2;
                num1 = result;
                updateShowResultTextView(result);
            }else if(operator.equals("-") ){
                num2 = Double.parseDouble(numberPressed);

                result =  num1 - num2;
                num1 = result;
                updateShowResultTextView(result);
            }
            else if(operator.equals("*") ){
                num2 = Double.parseDouble(numberPressed);

                result =  num1 * num2;
                num1 = result;
                updateShowResultTextView(result);

            }else if(operator.equals("/")){
                num2 = Double.parseDouble(numberPressed);

                result =  num1 / num2;
                num1 = result;
                updateShowResultTextView(result);
            }

        }else {
            num1 = Double.parseDouble(numberPressed);
            Log.i("BTNCLICK", "clicked");


        }
    }

    private void operatorPressed(String operator) {
        lastElement = inputValue.substring(inputValue.length() - 1);
        if(!lastElement.equals(operator)){
            if(operator == null || operator.isEmpty()){
                operator = operator;
                inputValue += operator;
                Log.i("OPERATORPRESSED", "operator is pressed firstTime");
            }else {
                inputValue = inputValue + operator;
                Log.i("LASTELEMENT",lastElement);


                Log.i("OPERATORPRESSED", "opeartor is not empty");
            }
        }
    }


    private boolean checkIfOperatorPressed(String inputValue) {
        if(operator == null || operator.isEmpty()){
            return false;
        }else {
            return true;
        }
    }
    private void updateShowResultTextView(Double result) {
        textViewShowResult.setText(result.toString());
    }

    private void updateResultTextView(String inputValue) {
        textViewResult.setText(inputValue);
    }
}
