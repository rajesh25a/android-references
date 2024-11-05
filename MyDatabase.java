package com.example.myroomdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    MyDatabase myDatabase;
    Context context;

    public static final String NAME = "Name";    //Column II
    public static final String MyPASSWORD = "Password";    // Column III
    private static final String TABLE_NAME = "myTable";   // Table Name
    private static final String DATABASE_NAME = "myDatabase";    // Database Name
    private static final int DATABASE_Version = 1;   // Database Version
    private static final String UID = "_id";     // Column I (Primary Key)

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + MyPASSWORD + " VARCHAR(225));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
    }


    public long insertUser(String name, String password) {
        // System.out.println(" insert user fun was called...........");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(MyPASSWORD, password);
        long id = db.insert(TABLE_NAME, null, contentValues);
        System.out.println("LONG IDDDDDDDD " + id);
        return id;
    }

    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {NAME, MyPASSWORD}; // Columns you want to retrieve

        return db.query(TABLE_NAME, projection, null, null, null, null, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.execSQL(DROP_TABLE);
        } catch (SQLException e) {
            System.out.println(context + e.getMessage());
        }
    }
}
