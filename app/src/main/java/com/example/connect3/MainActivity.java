package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    int player = 0;
    int[] gameState = {2,2,2, 2,2,2, 2,2,2};
    int [][] wins = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        int counterTag = Integer.parseInt(counter.getTag().toString());

        if(player == 0){
            counter.setImageResource(R.drawable.yellow);
            gameState[counterTag] = 0;
            player = 1;
        }else{
            counter.setImageResource(R.drawable.red);
            gameState[counterTag] = 1;
            player = 0;
        }

        counter.animate().translationYBy(1500).setDuration(800);

        for(int[] positions:  wins){
            if(gameState[positions[0]] == gameState[positions[1]] && gameState[positions[1]] == gameState[positions[2]] && gameState[positions[0]] != 2){
                String winner = "";
                if(player ==1){
                    winner = "yellow";
                }else{
                    winner = "red";
                }


                Toast.makeText(this, winner+ " has Won!", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
