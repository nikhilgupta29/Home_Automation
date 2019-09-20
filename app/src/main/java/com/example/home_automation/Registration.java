package com.example.home_automation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Registration extends AppCompatActivity {
    EditText name,email,pass,repassw,mob;
    Date db;
    Button submit;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.name);
        email = findViewById(R.id.mail);
        pass = findViewById(R.id.password);
        repassw = findViewById(R.id.repass);
        mob = findViewById(R.id.mob);
        submit = findViewById(R.id.button2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().length() == 0)
                {
                    name.setError("Please Enter your name");
                    name.requestFocus();
                }
                if(email.getText().toString().length() == 0)
                {
                 email.setError("Email should not be blank !!!!");
                 email.requestFocus();

                }
                if(email.getText().toString().trim().matches(emailPattern))
                {
                    email.setError("Valid Email !!!");
                    email.requestFocus();
                }
                else
                {
                    email.setError("InValid Email Address !!!");
                    email.requestFocus();
                }
                if(pass.getText().toString().length() == 0)
                {
                    pass.setError("Password Not Entered !!!!");
                    pass.requestFocus();
                }
                if(!pass.getText().toString().equals(repassw.getText().toString()))
                {
                    repassw.setError("Password Not matched !!!!");
                    repassw.requestFocus();
                }
                if(pass.getText().toString().length()<6)
                {
                    pass.setError("Password should be atleast of 8 characters !!!!!");
                }
                if(repassw.getText().toString().length() == 0)
                {
                    repassw.setError("Please Confirm your Password !!!! ");
                    repassw.requestFocus();
                }
                else
                {
                    Toast.makeText(Registration.this, "Successfully Registered !!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
