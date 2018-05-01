package com.hci.marsh189.giftgiving;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class GroupUserAdditionFragment extends Fragment {

    private String username;

    private Button doneBtn;
    private Button cancelBtn;
    private RecyclerView friendsRV;


    public static GroupUserAdditionFragment newInstance() {
        GroupUserAdditionFragment fragment = new GroupUserAdditionFragment();
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

        return inflater.inflate(R.layout.fragment_group_user_addition, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doneBtn = (Button) view.findViewById(R.id.doneBtn);
        friendsRV = (RecyclerView) view.findViewById(R.id.friendsRecyleView);
        cancelBtn = (Button) view.findViewById(R.id.friendsRecyleView);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*android.app.Fragment newGroupFrag = new NewGroupFragment();
                FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("username", username);
                newGroupFrag.setArguments(bundle);
                transaction.replace(R.id.frame_layout, newGroupFrag);
                transaction.commit();*/
            }
        });
    }
}
