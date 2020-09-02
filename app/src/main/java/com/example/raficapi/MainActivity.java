package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.Home:
                //newGame();
                return true;
            case R.id.Games:
                Intent intent = new Intent(this, TicTacToe.class);
                startActivity(intent);
                return true;
            case R.id.Stroller:
                Intent intent_strollers = new Intent(this, Strollers.class);
                startActivity(intent_strollers);
                return true;
            default:
                return super.onOptionsItemSelected(item);
            }
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