package com.rahulgoel.moviesdb.network;

import com.rahulgoel.moviesdb.Movie_Detail.Movie_result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vaibhav singh on 3/27/2016.
 */
public interface ApiInterface {
    @GET("top_rated")
    Call<Movie_result> getTopRated(@Query("api_key") String api_key);

    @GET("upcoming")
    Call<Movie_result> getUpcoming(@Query("api_key") String api_key);

    @GET("popular")
    Call<Movie_result> getPopular(@Query("api_key") String api_key);

    @GET("now_playing")
    Call<Movie_result> getNowPlaying(@Query("api_key") String api_key);
}
