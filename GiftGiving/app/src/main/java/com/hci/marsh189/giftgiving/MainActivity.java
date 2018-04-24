package com.hci.marsh189.giftgiving;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();
        BottomNavigationView bottonNav = (BottomNavigationView) findViewById(R.id.navigationView);
        bottonNav.setOnNavigationItemSelectedListener(NavItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener NavItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            Fragment fragment;
            switch (item.getItemId())
            {
                case R.id.navigation_friends:
                    toolbar.setTitle("Friends");
                    fragment = new FriendsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_groups:
                    toolbar.setTitle("Groups");
                    fragment = new GroupsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    fragment = new FriendsFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
