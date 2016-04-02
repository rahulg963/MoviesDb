package com.rahulgoel.moviesdb.Movie_Detail;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rahulgoel.moviesdb.R;
import com.squareup.picasso.Picasso;

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
        ImageView top;
        TextView bottom;
        //TextView movie_name_list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView=View.inflate(context,R.layout.adapter_top_rated,null);
            ViewHolder vh=new ViewHolder();
            ImageView top=(ImageView)convertView.findViewById(R.id.poster);
            TextView bottom=(TextView)convertView.findViewById(R.id.moviename);
            vh.top=top;
            vh.bottom=bottom;
            convertView.setTag(vh);
        }
        ViewHolder vh=(ViewHolder)convertView.getTag();
        Picasso.with(context).load("https://image.tmdb.org/t/p/w185"+movieList.get(position).getPoster_path()).fit().into(vh.top);
        vh.bottom.setText(movieList.get(position).getOriginal_title());
        return convertView;

    }
}
