package com.example.mahe.hrate;

import android.content.Intent;
import android.support.v4.app.Fragment;
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

public class QandA extends Fragment {
   // String[] friends={"Phani","Siddhu","Visal","Srinidhi","Abhnay","Boberdo Casslo","Phani","Siddhu","Visal","Srinidhi","Abhnay","Boberdo Casslo","Phani","Siddhu","Visal","Srinidhi","Abhnay","Boberdo Casslo"};
   // @Override
    public QandA()
    {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_rating,container,false);
        ListAdapter listAdapter=new QanaAAdapter(getContext(),MainActivity.q1,MainActivity.a1,MainActivity.p1 );
        ListView listView= (ListView) view.findViewById(R.id.ratinglistview);//(ListView) getActivity().findViewById(R.id.ratinglistview);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String friend=String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(getContext(),friend,Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getContext(),Main2Activity.class);
                        i.putExtra("extra1",MainActivity.q1.get(position));
                        i.putExtra("extra2",MainActivity.a1.get(position));
                        i.putExtra("extra3",MainActivity.p1.get(position));
                        startActivity(i);
                    }
                }
        );


        // Inflate the layout for this fragment
        return view;//inflater.inflate(R.layout.activity_rating, container, false);
       // return inflater.inflate(R.layout.activity_qand, container, false);
    }
}
