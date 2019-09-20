package com.example.home_automation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class Forgot extends AppCompatActivity {

    EditText mail,phone;
    Button otp;
    int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        mail = findViewById(R.id.editText3);
        phone = findViewById(R.id.editText4);
        otp =  findViewById(R.id.button3);

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                num = random.nextInt(9999);
                String message = "Your OTP is :- " +num;

            }
        });

    }
}
