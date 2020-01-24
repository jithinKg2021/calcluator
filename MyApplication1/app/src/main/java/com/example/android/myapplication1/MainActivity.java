package com.example.android.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Button b1,b2;
ImageView m1,m2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        m1=(ImageView) findViewById(R.id.img1);
        m2=(ImageView) findViewById(R.id.img2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // m1.setVisibility(View.INVISIBLE);
                m1.setImageResource(R.drawable.ic_launcher_foreground);
                m2.setImageResource(R.drawable.ic_launcher_background);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2.setImageResource(R.drawable.ic_launcher_foreground);
                m2.setImageResource(R.drawable.ic_launcher_background);
            }
        });
    }
}
