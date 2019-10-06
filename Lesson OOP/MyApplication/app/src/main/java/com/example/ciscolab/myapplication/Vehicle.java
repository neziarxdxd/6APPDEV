package com.example.ciscolab.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

public class Vehicle implements Serializable{
    String name;
    int numberOfWheels;

    Vehicle(){
        this.name="";
        this.numberOfWheels=0;
    }
}
