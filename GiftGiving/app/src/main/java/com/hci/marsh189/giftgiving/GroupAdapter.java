package com.hci.marsh189.giftgiving;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyViewHolder>
{
    private List<Group> groupsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView groupName;

        public MyViewHolder(View view) {
            super(view);
            groupName = (TextView) view.findViewById(R.id.groupName);
        }
    }


    public GroupAdapter(List<Group> groupsList) {
        this.groupsList = groupsList;
    }
    public List<Group> getGroupsList()
    {
        return groupsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Group group = groupsList.get(position);
        holder.groupName.setText(group.getGroupName());
    }

    @Override
    public int getItemCount() {
        return groupsList.size();
    }
}
