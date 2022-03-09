package com.in.lab.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.in.lab.R;
import com.in.lab.adapter.MyWalletTabAdapter;

public class MyWalletActivity extends AppCompatActivity {

    ImageView back;
    TextView headerTitle;


    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);

        init();
        clickEvent();
    }

    public void init() {

        back = findViewById(R.id.Back);
        headerTitle = findViewById(R.id.header_title);

        headerTitle.setText("My Wallet");

        tabLayout = findViewById(R.id.tabb);
        viewPager = findViewById(R.id.pager);

        tabLayout.addTab(tabLayout.newTab().setText("Wallet Transaction History"));
        tabLayout.addTab(tabLayout.newTab().setText("Request for Redemption"));
        tabLayout.addTab(tabLayout.newTab().setText("Deposit"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);


        MyWalletTabAdapter myWalletAdapter = new MyWalletTabAdapter(getSupportFragmentManager(), getApplicationContext(), tabLayout.getTabCount());
        viewPager.setAdapter(myWalletAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }

    public void clickEvent() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}