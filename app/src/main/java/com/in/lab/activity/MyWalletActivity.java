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
import com.in.lab.model.MyWalletModel;
import com.in.lab.services.Api;
import com.in.lab.services.Global;
import com.in.lab.services.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyWalletActivity extends AppCompatActivity {

    ImageView back;
    TextView headerTitle, myBalance;


    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);

        init();
        clickEvent();
        getWalletBalance(Global.token, Global.userId);
    }

    public void init() {

        Global.progressDialog(this);
        back = findViewById(R.id.Back);
        headerTitle = findViewById(R.id.header_title);
        myBalance = findViewById(R.id.myBalance);
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

    public void getWalletBalance(String token, String user_id) {

        Api call = RetrofitClient.getClient(Global.baseUrl).create(Api.class);
        Global.dialog.show();


        call.myWalletBalance(token, user_id).enqueue(new Callback<MyWalletModel>() {
            @Override
            public void onResponse(Call<MyWalletModel> call, Response<MyWalletModel> response) {


                MyWalletModel myWalletModel = response.body();
                myBalance.setText("₹ " +myWalletModel.getData().getWallet_balance());
                Global.dialog.dismiss();


            }

            @Override
            public void onFailure(Call<MyWalletModel> call, Throwable t) {
                Global.dialog.dismiss();

            }
        });
    }
}