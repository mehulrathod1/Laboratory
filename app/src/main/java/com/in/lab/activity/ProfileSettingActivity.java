package com.in.lab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.in.lab.R;

public class ProfileSettingActivity extends AppCompatActivity {

    ImageView back;
    TextView headerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);

        init();
        clickEvent();
    }

    public void init(){

        back = findViewById(R.id.Back);
        headerTitle = findViewById(R.id.header_title);

        headerTitle.setText("Profile Setting");

    }

    public void clickEvent(){

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}