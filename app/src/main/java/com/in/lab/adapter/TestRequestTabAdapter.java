package com.in.lab.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.in.lab.fragment.DepositFragment;
import com.in.lab.fragment.RedemptionFragment;
import com.in.lab.fragment.TestRequestCompletedFragment;
import com.in.lab.fragment.TestRequestUpcomingFragment;
import com.in.lab.fragment.TransactionHistoryFragment;


public class TestRequestTabAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;


    public TestRequestTabAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TestRequestCompletedFragment testRequestCompletedFragment = new TestRequestCompletedFragment();
                return testRequestCompletedFragment;

            case 1:
                TestRequestUpcomingFragment testRequestUpcomingFragment = new TestRequestUpcomingFragment();
                return testRequestUpcomingFragment;



            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public class ViewHolder {
    }
}
