package com.example.bhanuka.smartbasketballcoach;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mobileDB";
    public static final String PLAYER_INFO = "player_info";
    public static final String READINGS = "readings";
    public static final String FEEDBACKS = "feedbacks";

    public static final String COL_1 = "name";
    public static final String COL_2 = "birthday";
    public static final String COL_3 = "height";
    public static final String COL_4 = "weight";
    public static final String COL_5 = "status";

    public static final String COL_6 = "shoot_id";
    public static final String COL_7 = "date_time";
    public static final String COL_8 = "shoot_type";
    public static final String COL_9 = "distance_basket";
    public static final String COL_10 = "shooting_angle";
    public static final String COL_11 = "shooting_speed";
    public static final String COL_12 = "foot_angle";
    public static final String COL_13 = "arm_angle";
    public static final String COL_14 = "releasing_height";

    public static final String COL_15 = "feedback";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PLAYER_INFO + "(" +
                "name TEXT PRIMARY KEY NOT NULL," +
                "birthday TEXT," +
                "height INTEGER," +
                "weight INTEGER," +
                "status TEXT" +
                ")");

        db.execSQL("create table " + READINGS + "(" +
                "shoot_id INTERGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "date_time TEXT," +
                "shoot_type TEXT," +
                "distance_basket INTERGER," +
                "shooting_angle INTERGER," +
                "shooting_speed INTERGER," +
                "foot_angle INTERGER," +
                "arm_angle INTERGER," +
                "releasing_height INTERGER" +
                ")");

        db.execSQL("create table " + FEEDBACKS + "(" +
                "shoot_id INTEGER REFERENCES readings(shoot_id) NOT NULL," +
                "feedbak TEXT" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + PLAYER_INFO );
        db.execSQL("drop table if exists " + READINGS );
        db.execSQL("drop table if exists " + FEEDBACKS );
        onCreate(db);
    }
}
