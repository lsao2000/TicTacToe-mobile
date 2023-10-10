package com.example.tictactoemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.content.Intent;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private TextView playerOne;
    private TextView playerTwo;
    private String firstPlayer;
    private String secondPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        playerOne = (TextView) findViewById(R.id.playerOne);
        playerTwo = (TextView) findViewById(R.id.playerTwo);
        Intent getData = getIntent();
        firstPlayer = getData.getStringExtra("firstPlayerName");
        secondPlayer = getData.getStringExtra("secondPlayerName");
        playerOne.setText(firstPlayer);
        playerTwo.setText(secondPlayer);
    }
}