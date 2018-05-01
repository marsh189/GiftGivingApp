package com.hci.marsh189.giftgiving;

import java.util.List;

public class Group
{
    private String groupName;
    private List<User> userList;
    private String type;

    public Group(String groupName, List<User> userList, String type)
    {
        this.groupName = groupName;
        this.userList = userList;
        this.type = type;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
