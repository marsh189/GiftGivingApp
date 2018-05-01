package com.hci.marsh189.giftgiving;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserGroupAdapter extends RecyclerView.Adapter<UserGroupAdapter.MyViewHolder>
{
    private List<User> userList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.user_name);
        }
    }


    public UserGroupAdapter(List<User> userList) {
        this.userList = userList;
    }
    public List<User> getUserList()
    {
        return userList;
    }

    @Override
    public UserGroupAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_list_item, parent, false);

        return new UserGroupAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserGroupAdapter.MyViewHolder holder, int position) {
        User user = userList.get(position);
        holder.name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}