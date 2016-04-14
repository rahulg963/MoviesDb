package com.rahulgoel.moviesdb;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rahulgoel.moviesdb.Movie_Detail.Movie;
import com.rahulgoel.moviesdb.Movie_Detail.MovieAdapter;
import com.rahulgoel.moviesdb.Movie_Detail.Movie_result;
import com.rahulgoel.moviesdb.Movie_Detail.NowPlaying;
import com.rahulgoel.moviesdb.Movie_Detail.Popular;
import com.rahulgoel.moviesdb.Movie_Detail.Top_Rated;
import com.rahulgoel.moviesdb.Movie_Detail.Upcoming;
import com.rahulgoel.moviesdb.Movie_Detail.searchResult;
import com.rahulgoel.moviesdb.network.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> movieList;
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


    private void fetchMovies(String query) {
        Call<Movie_result> allUserCall = ApiClient.getInterface().getResult("c6c78d348b8d5ac03cf81336bb11f651", query);
        allUserCall.enqueue(new Callback<Movie_result>() {
            @Override
            public void onResponse(Call<Movie_result> call, Response<Movie_result> response) {
                Toast.makeText(getApplicationContext(),"Got Result",Toast.LENGTH_SHORT).show();
                Movie_result movies_result = response.body();
                movieList = new ArrayList<Movie>();
                for (int j = 0; j < 20; j++)
                {
                    movieList.add(movies_result.getResults().get(j));
                }
                Intent i = new Intent();
                i.setClass(MainActivity.this,searchResult.class);
                i.putExtra("searchedMovies", movieList);
                startActivity(i);
            }
            @Override
            public void onFailure(Call<Movie_result> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),"Searching...",Toast.LENGTH_SHORT).show();
/*
                //Toast.makeText(getApplicationContext(),"Searching",Toast.LENGTH_SHORT).show();
                // Fetch the data remotely
                fetchMovies(query);
                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();
                // Set activity title to search query
                // MainActivity.this.setTitle(query);
*/
                Intent i = new Intent();
                i.setClass(MainActivity.this, searchResult.class);
                i.putExtra("searchedMovies",query);
                startActivity(i);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Toast.makeText(getApplicationContext(),"NOT",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }
}
