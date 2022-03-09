package com.in.lab.activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.in.lab.R;
import com.in.lab.adapter.HomeTabAdapter;
import com.in.lab.adapter.MyReviewAdapter;
import com.in.lab.model.MyReviewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    NavigationView NavigationDrawer;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    TabLayout tabLayout;
    ViewPager viewPager;

    ImageView navigationClose, drawerOpen;

    RecyclerView reviewRecycler;
    MyReviewAdapter adapter;
    List<MyReviewModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        clickEvent();
        tab();
        recyclerData();
    }

    public void init() {


        reviewRecycler = findViewById(R.id.reviewRecycler);

        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.pager);

        drawerOpen = findViewById(R.id.drawerOpen);
        NavigationDrawer = findViewById(R.id.NavigationDrawer);
        drawerLayout = findViewById(R.id.my_drawer_layout);

        View headerLayout = NavigationDrawer.inflateHeaderView(R.layout.navigation_header);
        navigationClose = headerLayout.findViewById(R.id.nevBackHeader);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                Intent intent;
                switch (id) {

                    case R.id.profile:

//                        drawerLayout.close();
                        intent = new Intent(getApplicationContext(), ProfileSettingActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.labTest:


                        intent = new Intent(getApplicationContext(), TestRequestActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.myReview:

//                        drawerLayout.close();
                        intent = new Intent(getApplicationContext(), MyReviewActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.myWallet:

//                        drawerLayout.close();
                        intent = new Intent(getApplicationContext(), MyWalletActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.accountSetting:

//                        drawerLayout.close();
                        intent = new Intent(getApplicationContext(), AccountSettingActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.layout:

                        drawerLayout.close();
                        break;


                }
                return false;
            }
        });

    }

    public void clickEvent() {

        drawerOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        navigationClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.close();
            }
        });
    }

    public void tab() {
        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
        tabLayout.addTab(tabLayout.newTab().setText("Upcoming"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        HomeTabAdapter homeTabAdapter = new HomeTabAdapter(getSupportFragmentManager(), getApplicationContext(), tabLayout.getTabCount());
        viewPager.setAdapter(homeTabAdapter);
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

    public void recyclerData() {


        MyReviewModel model = new MyReviewModel("Mehul Rathod", "27/09/2021", "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo du");
        list.add(model);
        list.add(model);
//        list.add(model);
//        list.add(model);
//        list.add(model);
//        list.add(model);
//        list.add(model);
//        list.add(model);
//        list.add(model);
//        list.add(model);


        adapter = new MyReviewAdapter(list, getApplicationContext(), new MyReviewAdapter.Click() {
            @Override
            public void onItemClick(int position) {


            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        reviewRecycler.setLayoutManager(mLayoutManager);
        reviewRecycler.setNestedScrollingEnabled(false);
        reviewRecycler.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        drawerLayout.close();

    }
}