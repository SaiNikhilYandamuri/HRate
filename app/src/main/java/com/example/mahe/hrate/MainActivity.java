package com.example.mahe.hrate;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    public static final int RC_SIGN_IN = 1;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final String ANONYMOUS = "anonymous";
    private String mUsername;

DBHelper myDb;

    static double[] ratings;
    static String[] hosp;
    static String[] questions;
    static String[] answers;
    static String[] persons;
   static ArrayList<String> q1=new ArrayList<String>();
    static ArrayList<String> a1=new ArrayList<String>();
    static ArrayList<String> p1=new ArrayList<String>();
DBHelper1 myDb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

myDb=new DBHelper(this);
        myDb1=new DBHelper1(this);
        boolean isInserted =  myDb.insertData("KMC","3","1");
        /*if(isInserted == true)
            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();*/
         isInserted =  myDb.insertData("Apollo","4","1");
        /*if(isInserted == true)
            Toast.makeText(MainActivity.this,"Data 1 Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this,"Data 1 not Inserted",Toast.LENGTH_LONG).show();*/
        //isInserted =  myDb.insertData("Apollo","4");
        isInserted =  myDb.insertData("Gandhi","5","1");
        isInserted =  myDb.insertData("Medwin","3","1");
        isInserted =  myDb.insertData("Care","4","1");

        isInserted = myDb1.insert_2("What are syptoms of fever?","High Temperature","Nikhil");
        isInserted = myDb1.insert_2("I have ingestion what should I do?","Visit the Doctor. It's the best medicine","Phanindra Sai Siddamsetty");
        isInserted = myDb1.insert_2("Any suggestions for protein intake??","Dal, Chicken, Eggs,etc","Siddhartha Mallipedi");
        isInserted = myDb1.insert_2("I have pain in my stomach. What shoul I do?","You might try to take less oil food. Try taking pill and drink lots of water.","Srinidhi Bhat");
        isInserted = myDb1.insert_2("What is the medicine for headache?","Any paracetomal should do","Arjun Palwai");
//String s=myDb.getData();
      //Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
        viewAll();
        viewAll2();
        mFirebaseAuth = FirebaseAuth.getInstance();

        toolbar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addfragments(new Rating(),"Ratings");

        viewPagerAdapter.addfragments(new QandA(),"Q & A");
        //viewPagerAdapter.addfragments(new TopPaidFragment(),"TopPaid");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //Toast.makeText(MainActivity.this, "You're now signed in. Welcome to HRate.", Toast.LENGTH_SHORT).show();
                }else {
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(
                                            AuthUI.EMAIL_PROVIDER,
                                            AuthUI.GOOGLE_PROVIDER)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };


        //DeleteData();

    }
   public void viewAll() {

        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            //showMessage("Error","Nothing found");
            return;
        }
        ratings=new double[5];
       hosp =new String[5];
        int i = 0;
        //StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            hosp[i] = res.getString(0);
            ratings[i]=res.getInt(1);
            i++;
        }
    }
    public void viewAll2() {

        Cursor res = myDb1.getAllData2();
        if (res.getCount() == 0) {
            // show message
            //showMessage("Error","Nothing found");
            return;
        }
        questions = new String[5];
        answers = new String[5];
        persons = new String[5];
        int i = 0;
        //StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            if (!q1.contains(res.getString(0))) {
                q1.add(res.getString(0));
                a1.add(res.getString(1));
                p1.add(res.getString(2));
                // questions[i] = res.getString(0);
                //answers[i]= res.getString(1);
                //persons[i]=res.getString(2);
                i++;
            }
            else
            {

                a1.remove(i);
                a1.add(res.getString(1));
                //i++;
            }
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true; }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.setings:
                //newGame();
                Intent i=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(i);
                //Toast.makeText(this,"Post a query",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.aboutus:
                //showHelp();
                Intent i1 = new Intent(MainActivity.this,AboutUs.class);
                startActivity(i1);
                //Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.signout:
                AuthUI.getInstance().signOut(this);
                Toast.makeText(this,"Sign Out",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);     } }
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == RC_SIGN_IN) {
                        if (resultCode == RESULT_OK) {
                                // Sign-in succeeded, set up the UI
                                       // Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
                            } else if (resultCode == RESULT_CANCELED) {
                                // Sign in was canceled by the user, finish the activity
                                        //Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                    }
            }
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
    }


    public void DeleteData() {

                        Integer deletedRows = myDb.deleteData("HEllo");
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();

    }
    public void UpdateData() {

                        //boolean isUpdate = myDb.updateData("KMC","5","1");
                        //if(isUpdate == true)
                          //  Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        //else
                          //  Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();

    }
    public  void AddData() {

                       // boolean isInserted = myDb.insertData("KMC!!!","4.5","1" );
                       // if(isInserted == true)
                         //   Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        //else
                          //  Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

    }





}
