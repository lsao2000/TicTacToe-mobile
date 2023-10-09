package com.example.tictactoemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
public class AddPlayers extends AppCompatActivity {
    private Button playGame;
    private EditText firstPlayer;
    private EditText secondPlayer;
    private boolean validPlayer1, validPlayer2;
    private String player1, player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_players);
        playGame     = (Button) findViewById(R.id.playGame);
        firstPlayer  = (EditText) findViewById(R.id.firstPlayer);
        secondPlayer = (EditText) findViewById(R.id.secondPlayer);
        validPlayer1 = false;
        validPlayer2 = false;
        playGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(firstPlayer.getText().toString().isEmpty()){
                    firstPlayer.setError("Please fill out this box");
                    validPlayer1 = false;
                }else{
                    if(firstPlayer.getText().toString().length() < 4){
                        firstPlayer.setError("The player name must be at least 5 caracter");
                        validPlayer1 = false;
                    }
                    else{
                        validPlayer1 = true;
                    }
                }
                if(secondPlayer.getText().toString().isEmpty()){
                    secondPlayer.setError("Please fill out this box");
                    validPlayer2 = false;
                }else{
                    if (secondPlayer.getText().toString().length() < 4){
                        secondPlayer.setError("The player name must be at least 4 carracter");
                        validPlayer2 = false;
                    }else{
                        validPlayer2 = true;
                    }
                }
                if(validPlayer2 && validPlayer1){
                    player1 = firstPlayer.getText().toString();
                    player2 = secondPlayer.getText().toString();
                    Intent newIntent = new Intent(AddPlayers.this, MainActivity.class);
                    newIntent.putExtra("firstPlayerName", player1);
                    newIntent.putExtra("secondPlayerName", player2);
                    startActivity(newIntent);
                }
            }
        });

    }
}