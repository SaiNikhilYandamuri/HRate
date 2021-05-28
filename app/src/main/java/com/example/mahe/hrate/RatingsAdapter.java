package com.example.mahe.hrate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mahe on 08-03-2017.
 */
 class RatingsAdapter extends ArrayAdapter<String>{
    double[] rating;
    public RatingsAdapter(Context context, String[] friends, double[] ratings) {
        super(context, R.layout.ratings_a,friends);
        rating=ratings;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater ratingsInflater = LayoutInflater.from(getContext());
        View ratingsView = ratingsInflater.inflate(R.layout.ratings_a,parent,false);

        String singleFriends = getItem(position);
        TextView ratingsText = (TextView) ratingsView.findViewById(R.id.hospitalTextView);
        //ImageView ratingsImage= (ImageView)ratingsView.findViewById(R.id.photoImageView);
        TextView ratingsText1 = (TextView)ratingsView.findViewById(R.id.ratingsTextView);

        ratingsText.setText(singleFriends);
        //ratingsImage.setImageResource(R.drawable.homepage);
        ratingsText1.setText(""+rating[position]);
        return ratingsView;
    }
}
