package com.example.sanjayprajapati.smsu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by sanjayprajapati on 3/24/18.
 */

public class Services extends Fragment {
    Button test;
    BottomTabbedActivity bottomTabbedActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.services,null);
        test=(Button)v.findViewById(R.id.btn_test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new Search()).commit();
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Search()).commit();
            }
        });

        return v;
    }
}
