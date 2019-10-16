package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainGame extends AppCompatActivity {

    TextView textView ,textView2 ,resultTextView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= findViewById(R.id.playerChoice);
        textView2 = findViewById(R.id.computerChoice);
        resultTextView= findViewById(R.id.resultView);
    }
    public  void clickRock (View v){
        textView.setText("ROCK");
        Random("ROCK");
    }
    public  void clickPaper (View v){
        textView.setText("PAPER");
        Random("PAPER");
    }
    public  void clickScissors (View v){
        textView.setText("SCISSORS");
        Random("SCISSORS");
    }

    public void Random(String player){
        String choice [] ={"ROCK","PAPER","SCISSORS"};
        Random rand = new Random();
        int x = rand.nextInt(2);
        String decide= choice[x];
        if (x==0){textView2.setText(decide);}
        else if (x==1){textView2.setText(decide);}
        else if (x==2){textView2.setText(decide);}
        else{textView2.setText("WRONG");}

        if (decide.equals(player)){
           resultTextView.setText("DRAW");
        }
       else if (player.equals("PAPER") && decide.equals("ROCK")){
            resultTextView.setText("WIN!");
        }
        else if (player.equals("ROCK") && decide.equals("SCISSORS")){
            resultTextView.setText("WIN!");
        }
        else if (player.equals("SCISSORS") && decide.equals("PAPER")){
            resultTextView.setText("WIN!");
        }
        else {
            resultTextView.setText("YOU LOSE :< ");
            Intent intent = new Intent(MainGame.this,MainActivity.class);
            startActivity(intent);
        }
//09984295061



    }

}
