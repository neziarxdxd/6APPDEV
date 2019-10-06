package com.example.ciscolab.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView xLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        xLbl = this.findViewById(R.id.xLbl);

        Intent mainActivity = this.getIntent();
        Bundle extras = mainActivity.getExtras();
        String key1 = extras.getString("Key1");
        this.xLbl.setText(key1);

        Vehicle x = (Vehicle) extras.getSerializable("vehicle");
        this.xLbl.setText(x.name);

        this.finish();

    }
}
