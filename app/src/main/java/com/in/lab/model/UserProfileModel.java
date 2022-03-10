package com.in.lab.model;

import android.service.autofill.UserData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileModel {
    @SerializedName("status")
    @Expose
    boolean status;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("data")
    UserProfileData data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserProfileData getData() {
        return data;
    }

    public void setData(UserProfileData data) {
        this.data = data;
    }

    public class UserProfileData {
        @SerializedName("user_id")
        @Expose
        String user_id;

        @SerializedName("first_name")
        @Expose
        String first_name;

        @SerializedName("last_name")
        @Expose
        String last_name;

        @SerializedName("email")
        @Expose
        String email;

        @SerializedName("mobile_number")
        @Expose
        String mobile_number;

        @SerializedName("address")
        @Expose
        String address;

        @SerializedName("profile_image")
        @Expose
        String profile_image;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile_number() {
            return mobile_number;
        }

        public void setMobile_number(String mobile_number) {
            this.mobile_number = mobile_number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }
    }
}
