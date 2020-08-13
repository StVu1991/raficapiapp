package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.time.format.FormatStyle;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class MainActivity extends AppCompatActivity {

    EditText etExpectedDate;
    TextView tvCurrentMonth, tvText1, tvText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etExpectedDate = (EditText) findViewById(R.id.etExpectedDate);
        tvText1 = (TextView) findViewById(R.id.tvText1);
        tvText2 = (TextView) findViewById(R.id.tvText2);
        tvCurrentMonth = (TextView) findViewById(R.id.tvCurrentMonth);
    }

    public void buCalculate (View view){
        //int DOB = Integer.parseInt(etExpectedDate.getText().toString());


        LocalDate todayDate = LocalDate.now();
        String dateAfterString = "2020-10-03";

        //Parsing the date
        LocalDate dateBefore = LocalDate.parse(todayDate.toString());
        LocalDate dateAfter = LocalDate.parse(dateAfterString);

        //calculating number of days in between
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        tvText1.setText(" <3   Raficapi<3 dolazi za:");
        tvCurrentMonth.setText(String.valueOf(noOfDaysBetween) + " dan");
        tvText2.setText("Što znači da je <3 Mamaka <3 u 8. mjesecu");
    }
}