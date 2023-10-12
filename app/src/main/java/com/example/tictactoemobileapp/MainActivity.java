package com.example.tictactoemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.content.Intent;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBox = 1;
    private String firstPlayer;
    private String secondPlayer;
    private TextView playerOne;
    private TextView playerTwo;
    private LinearLayout playerLayuotOne, playerLayoutTwo;
    private ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        playerOne = (TextView) findViewById(R.id.playerOne);
        playerTwo = (TextView) findViewById(R.id.playerTwo);

        playerLayuotOne = (LinearLayout) findViewById(R.id.playerlayoutOne);
        playerLayoutTwo = (LinearLayout) findViewById(R.id.playerLayoutTwo);

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        image5 = (ImageView) findViewById(R.id.image5);
        image6 = (ImageView) findViewById(R.id.image6);
        image7 = (ImageView) findViewById(R.id.image7);
        image8 = (ImageView) findViewById(R.id.image8);
        image9 = (ImageView) findViewById(R.id.image9);
        // Calcule all the possibility to win in the game.
        combinationList.add(new int[] {0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});

        Intent getData = getIntent();
        firstPlayer = getData.getStringExtra("firstPlayerName");
        secondPlayer = getData.getStringExtra("secondPlayerName");
        playerOne.setText(firstPlayer);
        playerTwo.setText(secondPlayer);
        playerLayuotOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        playerLayoutTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        image1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(0)){

                }
            }
        });
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(1)){

                };
            }
        });
        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(2)){

                };

            }
        });
        image4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(3)){

                }
            }

        });
        image5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(4)){

                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               if(isboxSelectable(5)){

               }
           }
        });
        image7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(6)){

                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(7)){

                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isboxSelectable(8)){

                }
            }
        });
    }
    private void performActin(ImageView imageView, int boxPosition){
        boxPositions[boxPosition] = playerTurn;
        if(playerTurn == 1){
            imageView.setBackgroundResource(R.drawable.x_mark);
            if(checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this, playerOne.getText().toString(), MainActivity.this);
                winDialog.show();
            }else if (totalSelectedBox == 9){
                WinDialog winDialog1 = new WinDialog(MainActivity.this, "No ones win the game",MainActivity.this);
                winDialog1.show();
            }
        }
    }
    private boolean checkPlayerWin(){
        boolean response = false;
        for (int i =0; i < combinationList.size(); i++){
            int[] combination = combinationList.get(i);
            if(boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn && boxPositions[combination[2]] == playerTurn){
                response = true;
            }
        }
        return response;
    }
    private boolean isboxSelectable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition] == 0){
            response = true;
        }
        return response;
    }
}