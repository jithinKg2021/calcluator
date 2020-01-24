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
    Button btnSubtract;
    Button btnDivision;
    Button btnEquals;
    Button btnClear;

    String inputValue = "";
    TextView textViewResult;
    String operator = "";


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
        btnAdd = findViewById(R.id.buttonAdd);

        btnSeven.setOnClickListener((View.OnClickListener) this);
        btnEight.setOnClickListener((View.OnClickListener) this);
        btnNine.setOnClickListener((View.OnClickListener) this);
        btnFour.setOnClickListener((View.OnClickListener) this);
        btnFive.setOnClickListener((View.OnClickListener) this);
        btnSix.setOnClickListener((View.OnClickListener) this);
        btnOne.setOnClickListener((View.OnClickListener) this);
        btnTwo.setOnClickListener((View.OnClickListener) this);
        btnThree.setOnClickListener((View.OnClickListener) this);
//        btnAdd.setOnClickListener();
        textViewResult = findViewById(R.id.textView1);

    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.button7:
                Log.i("BTNCLICK", "clicked");
                inputValue += "7";
                updateResultTextView(inputValue);

                break;
            case R.id.button8:
                Log.i("BTNCLICK", "clicked");
                inputValue += "8";
                updateResultTextView(inputValue);
                break;
            case R.id.buttonAdd:
                Log.i("ADDBTN", "Add button clicked");
                if(operator == null || operator.isEmpty()){
                    Log.i("OPERATORPRESSED", "operator is pressed firstTime");
                }else {
                    Log.i("OPERATORPRESSED", "opeartor is not empty");
                }
                operator = "+";

                updateResultTextView(inputValue);

        }
    }

    private void updateResultTextView(String inputValue) {
        textViewResult.setText(inputValue);
    }
}
