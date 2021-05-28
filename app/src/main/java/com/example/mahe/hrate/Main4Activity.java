package com.example.mahe.hrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
String s1,s2;
    Button ans;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle b=getIntent().getExtras();
        s1=b.getString("question");
        s2=b.getString("ans");
        //Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
        ans=(Button)findViewById(R.id.answerbutton);
        e1=(EditText)findViewById(R.id.answeredit);

    }
    public void answer1(View v)
    {
DBHelper1 d=new DBHelper1(this);
       boolean b= d.update(s1,""+s2+"\n"+e1.getText());
        /*if(b)
        {
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
            String x=d.getData(s1);
            Toast.makeText(getApplicationContext(),x,Toast.LENGTH_SHORT).show();
        }
        else
        Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();*/
        Intent i=new Intent(Main4Activity.this,MainActivity.class);
        startActivity(i);
    }
}
