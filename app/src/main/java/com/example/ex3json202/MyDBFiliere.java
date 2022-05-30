package com.example.ex3json202;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBFiliere extends SQLiteOpenHelper {

    public static String DBNAME = "DBFILIERE.db";
    public static String TBNAME = "FILIERE";
    public static String COL1 = "code";
    public static String COL2 = "description";
    public static String COL3 = "niveau";
    public static String COL4 = "nbmodule";


    public MyDBFiliere(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TBNAME + "(" + COL1 + " text primary key," + COL2 + " text," + COL3 + " text," + COL4 + " integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + TBNAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long insert_filiere(SQLiteDatabase sqLiteDatabase, Filiere fil){
        ContentValues ct = new ContentValues();
        ct.put(COL1, fil.getCode());
        ct.put(COL2, fil.getDescription());
        ct.put(COL3, fil.getNiveau());
        ct.put(COL4, fil.getNbModule());
        return  sqLiteDatabase.insert(TBNAME,null,ct);

    }
}
