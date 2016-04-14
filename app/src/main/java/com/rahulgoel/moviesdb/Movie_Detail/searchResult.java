package com.rahulgoel.moviesdb.Movie_Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rahulgoel.moviesdb.MainActivity;
import com.rahulgoel.moviesdb.R;
import com.rahulgoel.moviesdb.network.ApiClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchResult extends AppCompatActivity {
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
        searchResult.this.setTitle("Searched Results");

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = movieList.get(position);
                //Toast.makeText(Top_Rated.this,movie.getOriginal_title(), Toast.LENGTH_LONG).show();
                Intent i = new Intent();
                i.setClass(searchResult.this, DetailedMovie.class);
                i.putExtra("DetailedMovie", movie);
                startActivity(i);
            }
        });

        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setVisibility(ProgressBar.VISIBLE);
        Intent intent = getIntent();
        String query = intent.getExtras().getString("searchedMovies");
        //https://api.themoviedb.org/3/search/movie?api_key=c6c78d348b8d5ac03cf81336bb11f651&query=batman
        Call<Movie_result> allUserCall = ApiClient.getInterface().getResult("c6c78d348b8d5ac03cf81336bb11f651", query);
        allUserCall.enqueue(new Callback<Movie_result>() {
            @Override
            public void onResponse(Call<Movie_result> call, Response<Movie_result> response) {
                Movie_result movies_result = response.body();
                progress.setVisibility(ProgressBar.GONE);
                if (movies_result.results.size() != 0 )
                {
                    for (int i = 0; i < 20; i++) {
                        movieList.add(movies_result.getResults().get(i));
                    }
                    adapter.notifyDataSetChanged();
                }
                else {
                    Intent i = new Intent();
                    i.setClass(searchResult.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"INVALID ENTRY",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Movie_result> call, Throwable t) {
//                progress.setVisibility(ProgressBar.GONE);
            }
        });
    }
}
