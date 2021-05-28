package com.example.mahe.hrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class basic_inside extends AppCompatActivity {
EditText editText;
    Button b,b1;
    TextView t1,t2;
    String s1,s2;
    Spinner spinner;
String rate;

    ArrayAdapter<Integer> adapter;
    ArrayList<Integer> a1=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_inside);
        Bundle bundle=getIntent().getExtras();
        s1=bundle.getString("extra1");
         s2=bundle.getString("extra2");
a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter= new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,a1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" is Selected", Toast.LENGTH_SHORT).show();
                //source=(String)parent.getItemAtPosition(position);
                rate=""+parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        t1=(TextView)findViewById(R.id.textview1);
        t2=(TextView)findViewById(R.id.textview2);
        //editText=(EditText)findViewById(R.id.rate);
        b=(Button)findViewById(R.id.rate_button);
b1=(Button)findViewById(R.id.back);
        t1.setText(s1);
        t2.setText(s2);
    }
    public void rate_method(View v)
    {
        //String rate=""+editText.getText();
        DBHelper d=new DBHelper(getApplicationContext());
        int f=Integer.parseInt(d.getCount(s1));
        f++;
        double s=Double.parseDouble(s2);
        double s4=s+Double.parseDouble(rate);
        d.updateData(s1,""+s4,""+f);
    }
    public void back_m(View v)
    {
        Intent i=new Intent(basic_inside.this,MainActivity.class);
        startActivity(i);
    }
}
