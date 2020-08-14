package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class UserDashboard extends AppCompatActivity {

    TextView tvMessage1, tvMessage2, tvDaysLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        Bundle b = getIntent().getExtras();
        String babyName = b.getString("babyname");
        String dateComing = b.getString("expdate");

        LocalDate expectedDate = LocalDate.parse(dateComing);

        //Parsiranje očekivanog datuma iz podatka dobivenog iz drugog activitya, ali nije formatiran u obliku u kojemu želimo pa ga je potrebno dobiti parsiranjem
        Integer expday = expectedDate.getDayOfMonth();
        Integer expyear = expectedDate.getYear();
        Month expmonth = expectedDate.getMonth();
        String expcromonth = null;
        if (String.valueOf(expmonth)=="OCTOBER"){
            expcromonth = "LISTOPAD";
        }

        //Izračunavanje koliko dana je ostalo do očekivanog datuma
        LocalDate todayDate = LocalDate.now();
        String dateAfterString = dateComing;
        LocalDate dateBefore = LocalDate.parse(todayDate.toString());
        LocalDate dateAfter = LocalDate.parse(dateAfterString);
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        tvMessage1 = (TextView) findViewById(R.id.tvMessage1);
        tvMessage1.setText("Mali " + babyName + " dolazi na svijet na datum");
        tvMessage2 = (TextView) findViewById(R.id.tvMessage2);
        tvMessage2.setText(String.valueOf(expday) + ". " + expcromonth.toLowerCase() + " " +  String.valueOf(expyear));
        tvDaysLeft = (TextView) findViewById(R.id.tvDaysLeft);
        tvDaysLeft.setText(String.valueOf(noOfDaysBetween) + " dana");
    }
}