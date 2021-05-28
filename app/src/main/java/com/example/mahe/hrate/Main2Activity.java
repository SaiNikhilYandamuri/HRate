package com.example.mahe.hrate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView t1,t2,t3;
    String s1,s2,s3;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle=getIntent().getExtras();
        s1=bundle.getString("extra1");
        s2=bundle.getString("extra2");
        s3=bundle.getString("extra3");
        t1=(TextView)findViewById(R.id.a2textview1);
        t2=(TextView)findViewById(R.id.a2textview2);
        t3=(TextView)findViewById(R.id.a2textview3);
        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        b=(Button)findViewById(R.id.answer);
    }
    public void answer(View w)
    {
        Intent i=new Intent(Main2Activity.this,Main4Activity.class);
        i.putExtra("question",s1);
        i.putExtra("ans",s2);
        startActivity(i);
    }
}
