package com.rahulgoel.moviesdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_tr = (Button)findViewById(R.id.button_tr);
        Button button_up = (Button) findViewById(R.id.button_up);
        Button button_np = (Button)findViewById(R.id.button_np);
        Button button_po = (Button) findViewById(R.id.button_po);

    }

    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.button_tr)
        {

        }
        if(id == R.id.button_up)
        {

        }
        if(id == R.id.button_np)
        {

        }
        if(id == R.id.button_po)
        {

        }
    }


}
