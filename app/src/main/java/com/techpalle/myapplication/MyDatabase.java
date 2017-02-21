package com.techpalle.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manasranjan on 1/4/2017.
 */
public class MyDatabase {
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;
    public MyDatabase(Context c){
        myHelper=new MyHelper(c,"techpalle.db",null,1);
    }
    public void open(){
        sqLiteDatabase=myHelper.getWritableDatabase();
    }
    public void insertStudent(String no,String name,String mobile,String email,String sub,String des,String time){
        ContentValues cv=new ContentValues();
        cv.put("sno",no);
        cv.put("sname",name);
        cv.put("smobile",mobile);
        cv.put("semail",email);
        cv.put("ssub",sub);
        cv.put("sdes",des);
        cv.put("stime",time);
        sqLiteDatabase.insert("student",null,cv);
    }
    public Cursor queryStudent(){
        Cursor c=null;
        c=sqLiteDatabase.query("student",null,null,null,null,null,null);
        return c;
    }
    public Cursor queryStudentname(String name){
        Cursor cursor = null;
        cursor = sqLiteDatabase.query("student", null, "sname =?", new String[]{name}, null, null, null);
        return cursor;
    }
    public Cursor queryStudentmobile(String mobile){
        Cursor cursor=null;
        cursor=sqLiteDatabase.query("student",null,"smobile=?",new String[]{mobile},null,null,null);
        return cursor;
    }
    public void close(){
        sqLiteDatabase.close();
    }
    private class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table student(_id integer primary key,sno text,sname text,smobile text,semail text,ssub text,sdes text,stime text);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
