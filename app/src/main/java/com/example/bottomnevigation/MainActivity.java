package com.example.bottomnevigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnview=findViewById(R.id.bnview);
        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.home){
                    loadFrag(new home(),true);

                }else if(id==R.id.setting){
                    loadFrag(new setting(),false);
                }else if(id==R.id.profil){
                    loadFrag(new profil(),false);
                }else {
                    loadFrag(new download(),false);
                }
                return true;
            }
        });
        bnview.setSelectedItemId(R.id.home);


    }
    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);

        ft.commit();
    }
}