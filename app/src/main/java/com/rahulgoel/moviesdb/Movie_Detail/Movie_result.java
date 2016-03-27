package com.rahulgoel.moviesdb.Movie_Detail;

import java.util.ArrayList;

/**
 * Created by Rahul Goel on 3/27/2016.
 */
public class Movie_result {
    public String page;
    public ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }


}
