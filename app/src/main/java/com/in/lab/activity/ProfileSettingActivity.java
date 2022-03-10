package com.in.lab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.in.lab.R;
import com.in.lab.model.UserProfileModel;
import com.in.lab.services.Api;
import com.in.lab.services.Global;
import com.in.lab.services.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileSettingActivity extends AppCompatActivity {

    ImageView back;
    TextView headerTitle, edtFirstName, edtLastName, edtEmail, edtMobileNumber, edtAddress, txtChoosePhoto;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setting);

        init();
        clickEvent();
        getUserProfile(Global.token, Global.userId);
    }

    public void init() {

        Global.progressDialog(this);

        back = findViewById(R.id.Back);
        headerTitle = findViewById(R.id.header_title);
        headerTitle.setText("Profile Setting");

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtMobileNumber = findViewById(R.id.edtMobileNumber);
        edtAddress = findViewById(R.id.edtAddress);
        txtChoosePhoto = findViewById(R.id.txtChoosePhoto);
        profileImage = findViewById(R.id.profileImage);

    }

    public void clickEvent() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void getUserProfile(String token, String user_id) {

        Api call = RetrofitClient.getClient(Global.baseUrl).create(Api.class);
        Global.dialog.show();

        call.getUserProfile(token, user_id).enqueue(new Callback<UserProfileModel>() {
            @Override
            public void onResponse(Call<UserProfileModel> call, Response<UserProfileModel> response) {

                UserProfileModel userProfileModel = response.body();

                UserProfileModel.UserProfileData model = userProfileModel.getData();
                edtFirstName.setText(model.getFirst_name());
                edtLastName.setText(model.getLast_name());
                edtEmail.setText(model.getEmail());
                edtMobileNumber.setText(model.getMobile_number());
                edtAddress.setText(model.getAddress());


                Glide.with(getApplicationContext()).load(model.getProfile_image()).into(profileImage);
                Global.dialog.dismiss();
            }

            @Override
            public void onFailure(Call<UserProfileModel> call, Throwable t) {
                Global.dialog.dismiss();
            }
        });
    }
}