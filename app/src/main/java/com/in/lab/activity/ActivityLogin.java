package com.in.lab.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.in.lab.R;
import com.in.lab.model.LoginModel;
import com.in.lab.services.Api;
import com.in.lab.services.Global;
import com.in.lab.services.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityLogin extends AppCompatActivity {

    Button btnLogIn;
    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        clickEvent();
    }

    public void init() {

        Global.progressDialog(this);

        btnLogIn = findViewById(R.id.btnSignIn);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

    }

    public void clickEvent() {


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtEmail.getText().toString().equals("")) {
                    edtEmail.setError("Please Enter Email");
                } else if (edtPassword.getText().toString().equals("")) {
                    edtPassword.setError("Please Enter Password");
                } else {

                    loginUser(Global.token,edtEmail.getText().toString(),edtPassword.getText().toString());
                }
            }
        });

    }

    public void loginUser(String token, String email, String password) {

        Api call = RetrofitClient.getClient(Global.baseUrl).create(Api.class);
        Global.dialog.show();


        call.login(token, email, password).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {

                LoginModel loginModel = response.body();


                Toast.makeText(getApplicationContext(), ""+loginModel.getMessage(), Toast.LENGTH_SHORT).show();

                Global.userId = loginModel.getData().getId();

                SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
                editor.putString("token", "123456789");
                editor.putString("id", Global.userId);
                editor.apply();
                editor.commit();

                Global.dialog.dismiss();

                Intent intent = new Intent(getApplicationContext(), AuthenticationActivity.class);
                startActivity(intent);

//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);

            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {

                Global.dialog.dismiss();
                Toast.makeText(getApplicationContext(), ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                Log.e("TAG", "onFailure: "+t.getMessage() );
            }
        });

    }
}