package com.hci.marsh189.giftgiving;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "giftgiving";


    public SQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_USERS_TABLE = "CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT, name TEXT, email TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS users");

        onCreate(db);
    }

    public boolean addUser(String username, String password, String name, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("name", name);
        values.put("email", email);

        long result = db.insert("users", null, values);
        db.close();

        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getUser(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery("select * from users where username = '" + username + "'", null);
        return results;
    }
}
