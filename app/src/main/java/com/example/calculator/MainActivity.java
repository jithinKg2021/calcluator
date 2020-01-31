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
    Button btnAdd;
    Button btnMult;
    Button buttonSubtraction;
    Button btnDivision;
    Button btnEquals;
    Button btnClearBtn;

    String inputValue = "";
    TextView textViewResult;
    TextView textViewShowResult;
    String operator = "";
    Double num1 ;
    Double num2 ;
    Double result;


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
        btnClearBtn = findViewById(R.id.btnClearBtn);

        btnAdd = findViewById(R.id.buttonAdd);
        buttonSubtraction = findViewById(R.id.buttonSubtraction);


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

        textViewResult = findViewById(R.id.textView1);
        textViewShowResult = findViewById(R.id.textView2);


    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.button7:
                inputValue += "7";
                if(checkIfOperatorPressed(operator)){
                    if(operator.equals("+")){
                       num2 = 7.0;

                        result =  num1 + num2;
                        num1 = result;
                        updateShowResultTextView(result);
                        updateResultTextView(inputValue);
                    }else if(operator.equals("-") ){
                        num2 = 7.0;

                        result =  num1 - num2;
                        num1 = result;
                        updateShowResultTextView(result);
                        updateResultTextView(inputValue);


                    }

                }else {
                    num1 = 7.0;
                    Log.i("BTNCLICK", "clicked");

                    updateResultTextView(inputValue);
                }

                break;
            case R.id.button8:
                Log.i("BTNCLICK", "clicked");
                inputValue += "8";
                updateResultTextView(inputValue);
                break;
            case R.id.buttonSubtraction:
                Log.i("BTNSUBT", "subtract button clicked");
                String lastElement = inputValue.substring(inputValue.length() - 1);
                if(!lastElement.equals("-")){
                    if(operator == null || operator.isEmpty()){
                        operator = "-";
                        inputValue += "-";
                    }else {
                        inputValue = inputValue + "-";
                    }
                }
                break;

            case R.id.buttonAdd:
                Log.i("ADDBTN", "Add button clicked");
                 lastElement = inputValue.substring(inputValue.length() - 1);
                if(!lastElement.equals("+")){
                    if(operator == null || operator.isEmpty()){
                        operator = "+";
                        inputValue += "+";
                        Log.i("OPERATORPRESSED", "operator is pressed firstTime");
                    }else {
                        inputValue = inputValue + "+";
                        Log.i("LASTELEMENT",lastElement);


                        Log.i("OPERATORPRESSED", "opeartor is not empty");
                    }
                }
                break;


        }
        updateResultTextView(inputValue);

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
