package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView number1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        number1 = findViewById(R.id.number1);
        getdata();
    }

    private void getdata(){
        String strPhoneNumber = getIntent().getStringExtra("phone_number");
        number1.setText(strPhoneNumber);
    }
}