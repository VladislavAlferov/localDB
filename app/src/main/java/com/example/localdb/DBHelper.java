package com.example.localdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper  extends SQLiteOpenHelper
{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "geoDB";
    public static final String TABLE = "main";

    public static final String KEY_ID = "_id";
    public static final String KEY_PLACE = "place";
    public static final String KEY_ADDR = "addres";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE + "(" + KEY_ID
                + " integer primary key," + KEY_PLACE + " text," + KEY_ADDR + " text" + ")");
        db.execSQL("INSERT INTO "+ TABLE +" (" + KEY_PLACE
                + ", " + KEY_ADDR  + ") VALUES ('Ресторан Zuma', 'Фонтанная 2');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE);
        onCreate(db);
    }

    public void delete(SQLiteDatabase db, long id){
        db.execSQL("Delete from " + TABLE + " WHERE _id = " + id);
    }
}