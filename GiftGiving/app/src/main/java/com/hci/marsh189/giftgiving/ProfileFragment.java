package com.hci.marsh189.giftgiving;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    private String username;
    private String name;
    private String email;

    public ImageButton newItemBtn;

    private TextView nameText;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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

        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameText = (TextView) view.findViewById(R.id.name);
        nameText.setText(name);
        newItemBtn = (ImageButton) view.findViewById(R.id.addItem);
        newItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Fragment NewItemFrag = new NewItemFrag();
                FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, NewItemFrag);
                transaction.commit();
            }
        });
    }

}
