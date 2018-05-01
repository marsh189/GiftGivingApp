package com.hci.marsh189.giftgiving;

import android.database.Cursor;

import java.util.List;

public class FriendsCollection
{
    private List<User> userList;

    public FriendsCollection(String username)
    {
        Cursor results = LoginActivity.db.getFriends(username);
        if(results.getCount() > 0)
        {
            while(results.moveToNext())
            {
                String n = results.getString(0);
                String u = results.getString(1);
                String e = results.getString(2);
                User newUser = new User(n, u, e);
                userList.add(newUser);
            }
        }
    }


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
