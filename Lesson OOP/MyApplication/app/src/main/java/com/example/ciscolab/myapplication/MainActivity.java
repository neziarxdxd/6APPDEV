package com.example.ciscolab.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnAction(View view){
        Log.d("Test", "This is a test");
        Intent intent = new Intent(this.getApplicationContext(),Main2Activity.class);
        intent.putExtra("Key1", "MainActivity");

        Vehicle vehicleX = new Vehicle();
        vehicleX.name = "This is vehicleX";
        intent.putExtra("vehicle",vehicleX);

        this.startActivity(intent);
    }
}
