package com.example.mahe.hrate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView textView= (TextView)findViewById(R.id.textView);
        textView.setText("H Rate is Android Mobile application which helps people to" +
                " rate Doctors and Hospitals. This platform also provides the users to have" +
                " queries related to health issues and about the quality the hospital " +
                "provides in a certain detail. People can give a review and rate about the" +
                " hospital and Doctors working in it. The user is also provided with information" +
                " about Hospitals. People also can write about their experiences. People can ask queries" +
                " regarding various health issues which helps people live happily. People can make " +
                "suggestions regarding the type of treatment that people should get for a certain disease.");
        TextView textView1 = (TextView)findViewById(R.id.textView2);
        textView1.setText("Developer: Sai Nikhil Yandamuri:)");
    }
}
