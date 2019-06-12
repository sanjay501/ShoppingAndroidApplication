package com.example.sanjayprajapati.smsu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemReselectedListener;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomTabbedActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_tabbed);

        BottomNavigationView navigationView=findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new Home());

    }
    private boolean loadFragment(Fragment fragment){
        if (fragment !=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;

    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        Fragment fragment =null;
        switch (item.getItemId()){
            case R.id.navigation_home:
                fragment=new Home();
                break;

            case R.id.navigation_account:
                fragment=new Account();
                break;

            case R.id.navigation_cart:
                fragment=new Search();
                break;

            case R.id.navigation_services:
                fragment=new Services();
                break;

        }
        return loadFragment(fragment);

    }




}
