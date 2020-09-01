package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();
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
            //Sprječavanje direktnog pristupa drugom activityu bez unosa podataka za login
            intent.putExtra("seckey", "1111");
            startActivity(intent);
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
    }

}