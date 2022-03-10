package com.in.lab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.in.lab.R;
import com.in.lab.services.Global;

public class SplashActivity extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT = 2000;
    SharedPreferences prefs;
    String TAG = "SplashActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String id = prefs.getString("id", "null");//"No name defined" is the default value.
        String token = prefs.getString("token", "null");
        String auth = prefs.getString("auth", "null");
//        prefs.edit().remove("auth");
        prefs.edit().commit();

        Log.e(TAG, "onCreate: " + id);
        Log.e(TAG, "onCreate: " + token);
        Log.e(TAG, "onCreate: " + auth);


        if (!id.equals(null)) {
            Global.userId = id;
        }
        if (auth.equals("null")) {
            moveNext(ActivityLogin.class);

        }

        if (auth.equals("no")) {
            moveNext(MainActivity.class);
        }

        if (auth.equals("yes")) {
            moveNext(AuthenticationActivity.class);

        }


    }


    public void moveNext(Class c) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), c);
                startActivity(i);
                finish();

            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}