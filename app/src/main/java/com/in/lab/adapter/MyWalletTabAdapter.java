package com.in.lab.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.in.lab.fragment.DepositFragment;
import com.in.lab.fragment.RedemptionFragment;
import com.in.lab.fragment.TransactionHistoryFragment;



public class MyWalletTabAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;


    public MyWalletTabAdapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TransactionHistoryFragment transactionHistory = new TransactionHistoryFragment();
                return transactionHistory;

            case 1:
                RedemptionFragment redemption = new RedemptionFragment();
                return redemption;

            case 2:
                DepositFragment depositFragment = new DepositFragment();
                return depositFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
