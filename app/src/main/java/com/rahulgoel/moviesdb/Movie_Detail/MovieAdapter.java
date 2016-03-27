package com.rahulgoel.moviesdb.Movie_Detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rahulgoel.moviesdb.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rahul Goel on 3/27/2016.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {

    Context context;
    ArrayList<Movie> movieList;
    public MovieAdapter(Context context, ArrayList<Movie> objects) {
        super(context, 0, objects);
        this.context = context;
        this.movieList = objects;
    }
    public static class ViewHolder
    {
        TextView movie_name_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = View.inflate(context, R.layout.adapter_top_rated, null);
            TextView movie_name_list = (TextView)convertView.findViewById(R.id.textView);
            ViewHolder vh = new ViewHolder();
            vh.movie_name_list = movie_name_list;
            convertView.setTag(vh);
        }
        Movie movie = movieList.get(position);
        ViewHolder vh = (ViewHolder)convertView.getTag();
        vh.movie_name_list.setText(movie.getOriginal_title());
        return convertView;
        //return super.getView(position, convertView, parent);
    }
}
