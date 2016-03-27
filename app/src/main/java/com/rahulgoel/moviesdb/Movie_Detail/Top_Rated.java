package com.rahulgoel.moviesdb.Movie_Detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.rahulgoel.moviesdb.R;
import com.rahulgoel.moviesdb.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Top_Rated extends AppCompatActivity {

    ArrayList<Movie> movieList;
    ListView lv;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top__rated);
        movieList = new ArrayList<Movie>();
        lv = (ListView)findViewById(R.id.listView);
        adapter = new MovieAdapter(this,movieList);
        lv.setAdapter(adapter);

        Call<Movie_result> allUserCall = ApiClient.getInterface().getTopRated("c6c78d348b8d5ac03cf81336bb11f651");
        allUserCall.enqueue(new Callback<Movie_result>() {
            @Override
            public void onResponse(Call<Movie_result> call, Response<Movie_result> response) {
                Movie_result movies_result = response.body();

                for(int i=0;i<20;i++)
                {
                        movieList.add(movies_result.getResults().get(i));

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Movie_result> call, Throwable t) {

            }
        });

    }
}
