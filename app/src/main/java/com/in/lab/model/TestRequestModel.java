package com.in.lab.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TestRequestModel {


    @SerializedName("status")
    @Expose
    boolean status;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("data")
    List<TestRequestData> testRequestData = new ArrayList<>();

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

    public List<TestRequestData> getTestRequestData() {
        return testRequestData;
    }

    public void setTestRequestData(List<TestRequestData> testRequestData) {
        this.testRequestData = testRequestData;
    }

    public static class TestRequestData {

        @SerializedName("booking_id")
        @Expose
        String booking_id;


        @SerializedName("booking_date")
        @Expose
        String booking_date;


        @SerializedName("patient_name")
        @Expose
        String patient_name;


        @SerializedName("last_test_name")
        @Expose
        String last_test_name;


        @SerializedName("last_test_result")
        @Expose
        String last_test_result;

        @SerializedName("ammount")
        @Expose
        String amount;

        public TestRequestData(String booking_id, String booking_date, String patient_name, String last_test_name, String last_test_result, String amount) {
            this.booking_id = booking_id;
            this.booking_date = booking_date;
            this.patient_name = patient_name;
            this.last_test_name = last_test_name;
            this.last_test_result = last_test_result;
            this.amount = amount;
        }

        public String getBooking_id() {
            return booking_id;
        }

        public void setBooking_id(String booking_id) {
            this.booking_id = booking_id;
        }

        public String getBooking_date() {
            return booking_date;
        }

        public void setBooking_date(String booking_date) {
            this.booking_date = booking_date;
        }

        public String getPatient_name() {
            return patient_name;
        }

        public void setPatient_name(String patient_name) {
            this.patient_name = patient_name;
        }

        public String getLast_test_name() {
            return last_test_name;
        }

        public void setLast_test_name(String last_test_name) {
            this.last_test_name = last_test_name;
        }

        public String getLast_test_result() {
            return last_test_result;
        }

        public void setLast_test_result(String last_test_result) {
            this.last_test_result = last_test_result;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}