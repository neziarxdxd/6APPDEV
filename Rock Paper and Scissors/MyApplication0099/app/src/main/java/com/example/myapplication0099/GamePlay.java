package com.example.myapplication0099;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GamePlay extends AppCompatActivity {

    RandomPlay computer= new RandomPlay();
    String decide = computer.ComputerDecide();
    TextView resultGame = findViewById(R.id.txtResultGame);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
    }
    public void Rock(View view){
        int player =computer.GameNow("r",decide);
        if(player==-1){
            Intent intent= new Intent(this,MainActivity.class);
        }
        else if (player==0){resultGame.setText("DRAW!");}
        else{resultGame.setText("YOU WIN!!");}
    }
    public  void Paper(View view){
        int player =computer.GameNow("p",decide);
        if(player==-1){
            Intent intent= new Intent(this,MainActivity.class);
        }
        else if (player==0){resultGame.setText("DRAW!");}
        else{resultGame.setText("YOU WIN!!");}
    }
    public void Scissor(View view){
        int player =computer.GameNow("s",decide);
        if(player==-1){
            Intent intent= new Intent(this,MainActivity.class);
        }
        else if (player==0){resultGame.setText("DRAW!");}
        else{resultGame.setText("YOU WIN!!");}

    }
}
