package com.hci.marsh189.giftgiving;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class FriendsFragment extends Fragment {
    public ImageButton newFriendBtn;
    final Bundle bundle = new Bundle();
    public static FriendsFragment newInstance() {
        FriendsFragment fragment = new FriendsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_friends, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newFriendBtn = (ImageButton) view.findViewById(R.id.addItem);

       newFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                /*Fragment newFriendFrag = NewFriendFragment.newInstance();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                final Bundle bundle = new Bundle();
                newFriendFrag.setArguments(bundle);
                transaction.replace(R.id.frame_layout, newFriendFrag);
                transaction.commit();*/
            }
        });
    }

}