package com.myapp.anit.learnandroiddevelopment.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.myapp.anit.learnandroiddevelopment.R;
import com.myapp.anit.learnandroiddevelopment.adapter.MainviewPagerAdapter;
import com.myapp.anit.learnandroiddevelopment.fragment.Fragment_advance;
import com.myapp.anit.learnandroiddevelopment.fragment.Fragment_beginner;
import com.myapp.anit.learnandroiddevelopment.fragment.Fragment_example;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager= (ViewPager) findViewById(R.id.view_pager);

        MainviewPagerAdapter adapter = new MainviewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_beginner(),"Beginner");
        adapter.addFragment(new Fragment_example(),"Examples");
        adapter.addFragment(new Fragment_advance(),"Advance");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
