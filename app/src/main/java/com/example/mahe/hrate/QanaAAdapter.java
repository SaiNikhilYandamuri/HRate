package com.example.mahe.hrate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mahe on 02-04-2017.
 */

public class QanaAAdapter extends ArrayAdapter<String> {
    ArrayList<String> q;ArrayList<String> a;ArrayList<String> p;
    public QanaAAdapter(Context context, ArrayList<String> questions, ArrayList<String> answers, ArrayList<String> persons) {
        super(context, R.layout.qanda_a,questions);
        a=answers;
        p=persons;
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
        ratingsText1.setText(""+p.get(position));
        return ratingsView;
    }
}
