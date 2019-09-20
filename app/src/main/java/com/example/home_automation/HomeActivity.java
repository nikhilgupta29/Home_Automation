package com.example.home_automation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    TextView forgot;
    Button login, sign;
    EditText user,pass;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    forgot = findViewById(R.id.textView);
    login = findViewById(R.id.button);
    sign = findViewById(R.id.signup);
    user = findViewById(R.id.editText);
    pass = findViewById(R.id.editText2);
    mFirebaseAuth = FirebaseAuth.getInstance();

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String mail = user.getText().toString();
            String pwd = pass.getText().toString();

            if(!mail.isEmpty() && !pwd.isEmpty())
            {
                mFirebaseAuth.createUserWithEmailAndPassword(mail,pwd).addOnCompleteListener(HomeActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });
            }
        }
    });
    sign.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(HomeActivity.this , Registration.class);
            startActivity(intent1);
        }
    });

    forgot.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(HomeActivity.this , Forgot.class);
            startActivity(intent);
        }
    });
    }
}
