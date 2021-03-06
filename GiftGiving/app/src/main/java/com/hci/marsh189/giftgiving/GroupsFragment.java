package com.hci.marsh189.giftgiving;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class GroupsFragment extends Fragment {


    private String username;
    private String name;
    private String email;

    private ImageButton newGroupBtn;
    private RecyclerView groupRV;

    public static GroupsFragment newInstance() {
        GroupsFragment fragment = new GroupsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        username = getArguments().getString("username");
        name = getArguments().getString("name");
        email = getArguments().getString("email");

        return inflater.inflate(R.layout.fragment_groups, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newGroupBtn = (ImageButton) view.findViewById(R.id.addGroupBtn);
        groupRV = (RecyclerView) view.findViewById(R.id.groupRecycleView);

        newGroupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newGroupFrag = new NewGroupFragment();
                FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                newGroupFrag.setArguments(bundle);
                transaction.replace(R.id.frame_layout, newGroupFrag);
                transaction.commit();
            }
        });
    }
}