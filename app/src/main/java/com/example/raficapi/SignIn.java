package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
    }

    String userName = "mamaka";
    String password = "1";
    String expectedDate = "2020-10-03";
    String babyName = "Rafael";

    public void buTryLogin(View view) {
        if (userName.equals(etUsername.getText().toString()) && password.equals(etPassword.getText().toString())){
            Intent intent = new Intent(this, UserDashboard.class);
            intent.putExtra("user", userName);
            intent.putExtra("expdate", expectedDate);
            intent.putExtra("babyname", babyName);
            startActivity(intent);
        }
    }
}