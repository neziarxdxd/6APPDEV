package com.example.ciscolab.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];

    private boolean player1Turn = true;

    private int roundCount;

    private int player1Points;
    private int player2Points;

  //  private TextView textViewPlayer1;
  //  private TextView textViewPlayer2;
    private TextView textViewTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   textViewPlayer1 = findViewById(R.id.text_view_1);
      //  textViewPlayer2 = findViewById(R.id.text_view_2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.btnReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (player1Turn) {
            textViewTurn = findViewById(R.id.txtPlayerTurn);
            textViewTurn.setText("Player 2 turn");

            ((Button) v).setText("X");
        } else {

            textViewTurn = findViewById(R.id.txtPlayerTurn);
            textViewTurn.setText("Player 1 turn");
            ((Button) v).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }

        return false;
    }

    private void player1Wins() {
        player1Points++;

        textViewTurn = findViewById(R.id.txtPlayerTurn);
        textViewTurn.setText("PLAYER 1 WINS");

        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;

        textViewTurn = findViewById(R.id.txtPlayerTurn);
        textViewTurn.setText("PLAYER 2 WINS");

        updatePointsText();
        resetBoard();
    }

    private void draw() {
        textViewTurn = findViewById(R.id.txtPlayerTurn);
        textViewTurn.setText("DRAW");

        resetBoard();
    }

    private void updatePointsText() {

    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1Turn = true;
    }


    private void resetGame() {


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
        textViewTurn = findViewById(R.id.txtPlayerTurn);
        textViewTurn.setText("Player 1 turn");

        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBoard();
    }
}