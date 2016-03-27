package com.rahulgoel.moviesdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rahulgoel.moviesdb.Movie_Detail.Movie_result;
import com.rahulgoel.moviesdb.Movie_Detail.NowPlaying;
import com.rahulgoel.moviesdb.Movie_Detail.Popular;
import com.rahulgoel.moviesdb.Movie_Detail.Top_Rated;
import com.rahulgoel.moviesdb.Movie_Detail.Upcoming;
import com.rahulgoel.moviesdb.network.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_tr = (Button)findViewById(R.id.button_tr);
        Button button_up = (Button) findViewById(R.id.button_up);
        Button button_np = (Button)findViewById(R.id.button_np);
        Button button_po = (Button) findViewById(R.id.button_po);

        button_tr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(getApplicationContext(),Top_Rated.class);
                startActivity(i);
            }
        });

        button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(),Upcoming.class);
                startActivity(i);
            }
        });

        button_po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Popular.class);
                startActivity(i);
            }
        });

        button_np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), NowPlaying.class);
                startActivity(i);
            }
        });

    }
}
