package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView  tvText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        int weekInYear = calendar.get(Calendar.WEEK_OF_YEAR);

        tvText4 = (TextView) findViewById(R.id.tvText4);
        tvText4.setText("Tjedan u godini: " + weekInYear);
    }

    public void buCalculate (View view){
        //int DOB = Integer.parseInt(etExpectedDate.getText().toString());
    }

    public void buLogin(View view) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

    public void buStartTTT(View view) {
        Intent intent = new Intent(this, TicTacToe.class);
        startActivity(intent);
    }
}