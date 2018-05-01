package com.hci.marsh189.giftgiving;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class NewGroupFragment extends Fragment {

    private String username;
    private String groupName;

    private TextView nameText;
    private Button addUserBtn;
    private RecyclerView userRV;
    private Spinner typeDropDown;
    private Button createGroupBtn;

    public static NewGroupFragment newInstance() {
        NewGroupFragment fragment = new NewGroupFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_group, container, false);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameText = (TextView) view.findViewById(R.id.groupName);
        addUserBtn = (Button) view.findViewById(R.id.addUserBtn);
        userRV = (RecyclerView) view.findViewById(R.id.userList);
        typeDropDown = (Spinner) view.findViewById(R.id.typeDropDown);
        createGroupBtn = (Button) view.findViewById(R.id.createBtn);

        username = getArguments().getString("username");

        String[] types = new String[]{"Type of Group", "Secret Santa"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, types);

        createGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                groupName = nameText.getText().toString();
                if(!groupName.isEmpty())
                {

                }
            }
        });
    }
}
