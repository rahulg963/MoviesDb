package com.rahulgoel.moviesdb.Movie_Detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.rahulgoel.moviesdb.R;
import com.rahulgoel.moviesdb.network.ApiClient;

import java.util.ArrayList;

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
        setContentView(R.layout.activity_search_result2);
        movieList = new ArrayList<Movie>();
        lv = (GridView)findViewById(R.id.gridView);
        searchResult.this.setTitle("Searched Movies");
        adapter = new MovieAdapter(this,movieList);
        lv.setAdapter(adapter);
        Intent intent = getIntent();
        String query = intent.getExtras().getString("searchedMovies");
        Call<Movie_result> allUserCall = ApiClient.getInterface().getResult("c6c78d348b8d5ac03cf81336bb11f651", query);
        allUserCall.enqueue(new Callback<Movie_result>() {
            @Override
            public void onResponse(Call<Movie_result> call, Response<Movie_result> response) {
                Movie_result movies_result = response.body();
               // progress.setVisibility(ProgressBar.GONE);
                Log.i("Response", "Data Received");
                for (int i = 0; i < 20; i++) {
                    movieList.add(movies_result.getResults().get(i));
                }
                adapter.notifyDataSetChanged();
                Log.e("item", movieList.get(0).getOriginal_title());
            }
            @Override
            public void onFailure(Call<Movie_result> call, Throwable t) {
                Log.i("Failure","Not Received");
            }
        });
    }
}
