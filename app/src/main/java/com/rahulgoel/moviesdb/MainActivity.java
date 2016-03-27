package com.rahulgoel.moviesdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rahulgoel.moviesdb.Movie_Detail.Movie_result;
import com.rahulgoel.moviesdb.Movie_Detail.Top_Rated;
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


           }
/*
    public void onClick(View v){
        int id = v.getId();
        if(id == R.id.button_tr)

        {
            Call<Movie_result> allUserCall = ApiClient.getInterface().getTopRated("c6c78d348b8d5ac03cf81336bb11f651");
            allUserCall.enqueue(new Callback<Movie_result>() {
                @Override
                public void onResponse(Call<Movie_result> call, Response<Movie_result> response) {
                    Movie_result movies = response.body();
                    Toast.makeText(MainActivity.this,"Hello ", Toast.LENGTH_SHORT).show();
                }
                @Override
                public void onFailure(Call<Movie_result> call, Throwable t) {

                }
            });

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
*/

}
