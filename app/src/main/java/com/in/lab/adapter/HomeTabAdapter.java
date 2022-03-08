package com.in.lab.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.in.lab.fragment.RequestCompletedFragment;
import com.in.lab.fragment.RequestUpcomingFragment;

public class HomeTabAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;


    public HomeTabAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                RequestCompletedFragment completedFragment = new RequestCompletedFragment();
                return completedFragment;

            case 1:
                RequestUpcomingFragment upcomingFragment = new RequestUpcomingFragment();
                return upcomingFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
