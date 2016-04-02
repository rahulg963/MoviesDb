package com.rahulgoel.moviesdb.Movie_Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rahulgoel.moviesdb.R;
import com.rahulgoel.moviesdb.network.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Top_Rated extends AppCompatActivity {

    ArrayList<Movie> movieList;
    GridView lv;
    MovieAdapter adapter;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        movieList = new ArrayList<Movie>();
        lv = (GridView)findViewById(R.id.gridView);
        adapter = new MovieAdapter(this,movieList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = movieList.get(position);
                //Toast.makeText(Top_Rated.this,movie.getOriginal_title(), Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                i.setClass(Top_Rated.this, DetailedMovie.class);
                i.putExtra("DetailedMovie", movie);
                startActivity(i);
            }
        });

        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setVisibility(ProgressBar.VISIBLE);
        Call<Movie_result> allUserCall = ApiClient.getInterface().getTopRated("c6c78d348b8d5ac03cf81336bb11f651");
        allUserCall.enqueue(new Callback<Movie_result>() {
            @Override
            public void onResponse(Call<Movie_result> call, Response<Movie_result> response) {
                Movie_result movies_result = response.body();
                progress.setVisibility(ProgressBar.GONE);
                for (int i = 0; i < 20; i++) {
                    movieList.add(movies_result.getResults().get(i));

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Movie_result> call, Throwable t) {
                progress.setVisibility(ProgressBar.GONE);
            }
        });


    }
}
