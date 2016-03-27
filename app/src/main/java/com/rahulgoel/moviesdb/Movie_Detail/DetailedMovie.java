package com.rahulgoel.moviesdb.Movie_Detail;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.rahulgoel.moviesdb.R;

public class DetailedMovie extends AppCompatActivity {

    Movie movie;
    TextView adult;
    TextView release_date;
    TextView original_language;
    TextView original_title;
    TextView vote_average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_movie);
        adult = (TextView) findViewById(R.id.adult);
        release_date = (TextView) findViewById(R.id.release_date);
        original_language = (TextView) findViewById(R.id.original_language);
        original_title = (TextView) findViewById(R.id.original_title);
        vote_average = (TextView) findViewById(R.id.vote_average);

        movie = (Movie)getIntent().getSerializableExtra("DetailedMovie");

        adult.setText(" Is Adult : " + movie.isAdult() );
        release_date.setText( "Release Date : " + movie.getRelease_date());
        original_language.setText(" Language : " + movie.getOriginal_language());
        original_title.setText(" Title : " + movie.getOriginal_title());
        vote_average.setText(" Vote Average : " + movie.getVote_average());
    }

}
