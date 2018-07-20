package com.myapp.anit.learnandroiddevelopment.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainviewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrFragment = new ArrayList<>();
    private ArrayList<String> arrTitle = new ArrayList<>();
    public MainviewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return arrFragment.get(i);
    }

    @Override
    public int getCount() {
        return arrFragment.size();
    }

    public void addFragment(Fragment fragment,String title){
        arrFragment.add(fragment);
        arrTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrTitle.get(position);
    }
}
