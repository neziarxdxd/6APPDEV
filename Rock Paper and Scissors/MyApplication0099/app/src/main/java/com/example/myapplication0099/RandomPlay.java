package com.example.myapplication0099;

import android.content.Intent;

import java.lang.reflect.Array;
import java.util.Random;

public class RandomPlay {

    String x[]= {"r","p","s"};
    Random rn = new Random();

    public String ComputerDecide(){
        int index=rn.nextInt(4);

        return x[index];

    }

    public int GameNow (String userPlay, String computerPlay){
        if (userPlay.equals(computerPlay)){
            System.out.println("DRAW");
            return 0;

        }
        else if( userPlay.equals("p") && computerPlay.equals("r")){
            System.out.println("You win");
            return 1;
        }
        else if ( userPlay.equals("r") && computerPlay.equals("s")){
            System.out.println("You win");
            return 1;

        }
        else if(userPlay.equals("s") && computerPlay.equals("p")){

            System.out.println("You win");
            return 1;
        }
        else{
            System.out.println("YOU LOSE!!!");
            return -1;



        }

    }
}
