package com.in.lab.services;

import com.in.lab.model.CommonModel;
import com.in.lab.model.LoginModel;
import com.in.lab.model.MyWalletModel;
import com.in.lab.model.TestRequestModel;
import com.in.lab.model.TransactionHistoryModel;
import com.in.lab.model.UserProfileModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginModel> login(
            @Field("token") String token,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("my_wallet.php")
    Call<MyWalletModel> myWalletBalance(
            @Field("token") String token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("withdrawal_request.php")
    Call<CommonModel> withdrawalRequest(
            @Field("token") String token,
            @Field("user_id") String user_id,
            @Field("amount") String amount
    );


    @FormUrlEncoded
    @POST("get_user_profile.php")
    Call<UserProfileModel> getUserProfile(

            @Field("token") String token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("wallet_transaction_history.php")
    Call<TransactionHistoryModel> getTransactionHistory(

            @Field("token") String token,
            @Field("user_id") String user_id
    );


    @FormUrlEncoded
    @POST("get_upcoming_lab_test.php")
    Call<TestRequestModel> getUpcomingTest(

            @Field("token") String token,
            @Field("user_id") String user_id
    );


}
