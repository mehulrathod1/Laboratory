package com.in.lab.services;

import android.app.ProgressDialog;
import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Global {

    public static String baseUrl = "http://ciam.notionprojects.tech/api/laboratory/";
    public static ProgressDialog dialog;

    public static String token = "123456789";

    public static String userId;


    public static void progressDialog(Context context) {
        dialog = new ProgressDialog(context);
        dialog.setCancelable(false); // set cancelable to false
        dialog.setMessage("Please Wait"); // set message

    }


}
