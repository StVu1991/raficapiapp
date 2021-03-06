package com.example.raficapi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
    }

    public void buFieldClicked(View view) {
        Button buSelected = (Button) view;
        int FieldID = 0;
        switch ((buSelected.getId())){
            case R.id.bu1:
                FieldID=1;
            break;
            case R.id.bu2:
                FieldID=2;
            break;
            case R.id.bu3:
                FieldID=3;
            break;
            case R.id.bu4:
                FieldID=4;
            break;
            case R.id.bu5:
                FieldID=5;
            break;
            case R.id.bu6:
                FieldID=6;
            break;
            case R.id.bu7:
                FieldID=7;
            break;
            case R.id.bu8:
                FieldID=8;
            break;
            case R.id.bu9:
                FieldID=9;
            break;
        }
        PlayGame(FieldID, buSelected);
    }

    int ActivePlayer = 1; //To differentiate between players
    ArrayList<Integer> ArrPlayer1 = new ArrayList<>(); //There will be stored Player 1 data
    ArrayList<Integer> ArrPlayer2 = new ArrayList<>(); //There will be stored Player 2 data

    void PlayGame(int FieldID, Button buSelected){
        Log.d("Player:", String.valueOf(FieldID));

        if (ActivePlayer == 1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.GREEN);
            ArrPlayer1.add(FieldID);
            ActivePlayer = 2;
            AutoPlay();
        }
        else if (ActivePlayer == 2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.RED);
            ArrPlayer2.add(FieldID);
            ActivePlayer = 1 ;
        }

        buSelected.setEnabled(false); //To prevent repeated clicking of same button
        CheckWinner();
    }

    void AutoPlay(){
        ArrayList<Integer> EmptyCells = new ArrayList<>(); //All unselected cells
        //Find emtpy field
        for (int cellID=1; cellID<10 ;cellID++){
            if (!(ArrPlayer1.contains(cellID) || ArrPlayer2.contains(cellID))){
                EmptyCells.add(cellID);
            }
        }

        Random r = new Random();
        int RandomCell = r.nextInt(EmptyCells.size()-0) + 0; //
        int CellID = EmptyCells.get(RandomCell);

        Button buSelected;
        switch (CellID){
            case 1:
                buSelected = (Button) findViewById(R.id.bu1);
                break;
            case 2:
                buSelected = (Button) findViewById(R.id.bu2);
                break;
            case 3:
                buSelected = (Button) findViewById(R.id.bu3);
                break;
            case 4:
                buSelected = (Button) findViewById(R.id.bu4);
                break;
            case 5:
                buSelected = (Button) findViewById(R.id.bu5);
                break;
            case 6:
                buSelected = (Button) findViewById(R.id.bu6);
                break;
            case 7:
                buSelected = (Button) findViewById(R.id.bu7);
                break;
            case 8:
                buSelected = (Button) findViewById(R.id.bu8);
                break;
            case 9:
                buSelected = (Button) findViewById(R.id.bu9);
                break;
            default:
                buSelected = (Button) findViewById(R.id.bu1);
                break;
        }
        PlayGame(CellID, buSelected);
    }


    void CheckWinner(){
        int Winner = -1;
        if (ArrPlayer1.contains(1) && ArrPlayer1.contains(2) && ArrPlayer1.contains(3)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(1) && ArrPlayer2.contains(2) && ArrPlayer2.contains(3)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(4) && ArrPlayer1.contains(5) && ArrPlayer1.contains(6)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(4) && ArrPlayer2.contains(5) && ArrPlayer2.contains(6)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(7) && ArrPlayer1.contains(8) && ArrPlayer1.contains(9)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(7) && ArrPlayer2.contains(8) && ArrPlayer2.contains(9)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(1) && ArrPlayer1.contains(4) && ArrPlayer1.contains(7)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(1) && ArrPlayer2.contains(4) && ArrPlayer2.contains(7)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(2) && ArrPlayer1.contains(5) && ArrPlayer1.contains(8)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(2) && ArrPlayer2.contains(5) && ArrPlayer2.contains(8)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(3) && ArrPlayer1.contains(6) && ArrPlayer1.contains(9)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(3) && ArrPlayer2.contains(6) && ArrPlayer2.contains(9)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(1) && ArrPlayer1.contains(5) && ArrPlayer1.contains(9)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(1) && ArrPlayer2.contains(5) && ArrPlayer2.contains(9)){
            Winner = 2 ;
        }
        if (ArrPlayer1.contains(3) && ArrPlayer1.contains(5) && ArrPlayer1.contains(7)){
            Winner = 1 ;
        }
        if (ArrPlayer2.contains(3) && ArrPlayer2.contains(5) && ArrPlayer2.contains(7)){
            Winner = 2 ;
        }

        if (Winner != -1){
            //Someone wins game
            if (Winner == 1){
                Toast.makeText(this, "Player 1 is winner", Toast.LENGTH_LONG).show();
            }
            if (Winner == 2){
                Toast.makeText(this, "Player 2 is winner", Toast.LENGTH_LONG).show();
            }
        }
    }

}