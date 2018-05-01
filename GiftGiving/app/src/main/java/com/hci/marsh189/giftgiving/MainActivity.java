package com.hci.marsh189.giftgiving;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private String name;
    private String email;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        this.name = getIntent().getStringExtra("name");
        this.username = getIntent().getStringExtra("username");
        this.email = getIntent().getStringExtra("email");

        final Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("name", name);
        bundle.putString("email", email);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.friendsBtn:
                                selectedFragment = FriendsFragment.newInstance();
                                break;
                            case R.id.groupsBtn:
                                selectedFragment = GroupsFragment.newInstance();
                                break;
                            case R.id.profileBtn:
                                selectedFragment = ProfileFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        selectedFragment.setArguments(bundle);
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        ProfileFragment prof = new ProfileFragment();
        prof.setArguments(bundle);
        trans.replace(R.id.frame_layout, prof);
        trans.commit();

    }
    public void newFriend(){

    }
}
