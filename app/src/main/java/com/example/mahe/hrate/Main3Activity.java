package com.example.mahe.hrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
Button b1,b2;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        e1=(EditText)findViewById(R.id.editTextpost);
        b1=(Button)findViewById(R.id.post);
        b2=(Button)findViewById(R.id.back_post);
    }
    public void post(View v)
    {
        DBHelper1 d=new DBHelper1(this);
        d.insert_2(""+e1.getText(),"","Hello");
    }
    public void back_p(View v)
    {
        Intent i=new Intent(Main3Activity.this,MainActivity.class);
        startActivity(i);
    }
}
