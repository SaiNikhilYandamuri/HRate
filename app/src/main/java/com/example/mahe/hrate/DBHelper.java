package com.example.mahe.hrate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static com.facebook.FacebookSdk.getApplicationContext;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "HRate.db";
    public static final String TABLE_NAME = "ratings_table";
    public static final String COL_1 = "HOSPITAL_NAME";
    public static final String COL_2 = "RATINGS";
  public static final String COL_3 = "COUNT";

  //  public static final String COL_4 = "EMAIL";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (HOSPITAL_NAME TEXT PRIMARY KEY,RATINGS NUMERIC,COUNT INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(db);
    }

    public boolean insertData(String name,String rate,String count) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,Double.parseDouble(rate));
        contentValues.put(COL_3,Integer.parseInt(count));
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public String getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where RATINGS= ? ",new String[] {"3"});
        res.moveToFirst();
        String r=res.getString(0);
        return r;
    }
    public String getCount(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where HOSPITAL_NAME= ? ",new String[] {name});
        res.moveToFirst();
        String r=res.getString(2);
        return r;
    }

    public boolean updateData(String name,String rate,String count) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        double d=(double) Double.parseDouble(rate)/Integer.parseInt(count);
        //Toast.makeText(getApplicationContext(),""+d,Toast.LENGTH_LONG).show();
        contentValues.put(COL_2,d);
        contentValues.put(COL_3,Integer.parseInt(count));
        //contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "HOSPITAL_NAME = ?",new String[] { name });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "HOSPITAL_NAME = ?",new String[] {id});
    }


}


