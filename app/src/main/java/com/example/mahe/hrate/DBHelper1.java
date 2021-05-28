package com.example.mahe.hrate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by mahe on 02-04-2017.
 */

public class DBHelper1 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME2 = "HRate1.db";
    public static final String TABLE_NAME2 = "qanda_table";
    public static final String COL_2_1 = "QUESTION";
    public static final String COL_2_2 = "ANSWER";
    public static final String COL_2_3 = "PERSON";
    public DBHelper1(Context context) {
        super(context, DATABASE_NAME2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table " + TABLE_NAME +" (HOSPITAL_NAME TEXT PRIMARY KEY,RATINGS NUMERIC,COUNT INTEGER)");
        db.execSQL("create table " + TABLE_NAME2+" (QUESTION TEXT PRIMARY KEY,ANSWER TEXT,PERSON TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     //   db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
    }
    public boolean insert_2(String q,String a,String p)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_1,q);
        contentValues.put(COL_2_2,a);
        contentValues.put(COL_2_3,p);
        long result = db.insert(TABLE_NAME2,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData2() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }
    public boolean update(String question,String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2_1,question);
        //double d=(double) Double.parseDouble(rate)/Integer.parseInt(count);
        //Toast.makeText(getApplicationContext(),""+d,Toast.LENGTH_LONG).show();
        contentValues.put(COL_2_2,answer);
        //contentValues.put(COL_3,Integer.parseInt(count));
        //contentValues.put(COL_4,marks);
        db.update(TABLE_NAME2, contentValues, "QUESTION = ?",new String[] { question });
        return true;
    }
    public String getData(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2+" where QUESTION= ? ",new String[] {s});
        res.moveToFirst();
        String r=res.getString(1);
        return r;
    }

}
