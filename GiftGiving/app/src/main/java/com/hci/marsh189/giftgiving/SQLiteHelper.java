package com.hci.marsh189.giftgiving;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

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
        {
            String CREATE_USER_GROUP_TABLE = "CREATE TABLE " + username + "_groups (groupName TEXT PRIMARY KEY, users TEXT, type TEXT)";
            db.execSQL(CREATE_USER_GROUP_TABLE);
            String CREATE_USER_FRIEND_TABLE = "CREATE TABLE " + username + "_friends (friendName TEXT PRIMARY KEY, username TEXT, email TEXT)";
            db.execSQL(CREATE_USER_FRIEND_TABLE);
            return false;
        }
        else
            return true;
    }

    public Cursor getUser(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery("select * from users where username = '" + username + "'", null);
        return results;
    }

    public Cursor getGroups(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery("select * from " + username + "_groups", null);
        return results;
    }

    public boolean createGroup(String username, String groupName, List<User> userList, String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("groupName", groupName);
        values.put("type", type);
        String users = username;
        for(int x = 0; x < userList.size(); x++)
        {
            users += (" | " + userList.get(x).getName());
        }

        values.put("users", users);
        long result = db.insert(username + "_groups", null, values);
        db.close();
        if (result == -1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean createFriend(String username, User newFriend)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("friendName", newFriend.getName());
        values.put("username",newFriend.getUsername());
        values.put("email", newFriend.getEmail());

        long result = db.insert(username + "_friends", null, values);
        db.close();
        if (result == -1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public Cursor getFriends(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor results = db.rawQuery("select * from " + username + "_friends", null);
        return results;
    }
}
