package com.example.mahe.hrate;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Rating extends Fragment {

String[] friends={"KMC","Apollo","Gandhi","Medwin","Care"};

    //@Override
    public Rating()
    {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//viewAll();
        View view= inflater.inflate(R.layout.activity_rating,container,false);
        ListAdapter listAdapter=new RatingsAdapter(getContext(),MainActivity.hosp,MainActivity.ratings);//ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,friends);
        ListView listView= (ListView) view.findViewById(R.id.ratinglistview);//(ListView) getActivity().findViewById(R.id.ratinglistview);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String friend=String.valueOf(parent.getItemAtPosition(position));

                       // Toast.makeText(getContext(),friend,Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getContext(),basic_inside.class);
                        i.putExtra("extra1",friend);
                        i.putExtra("extra2",""+MainActivity.ratings[position]);
                        startActivity(i);
                    }
                }
        );


        // Inflate the layout for this fragment
        return view;//inflater.inflate(R.layout.activity_rating, container, false);
    }




}
