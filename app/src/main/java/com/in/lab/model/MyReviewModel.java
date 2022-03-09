package com.in.lab.model;

public class MyReviewModel {

    String Name,Date,ReviewText;

    public MyReviewModel(String name, String date, String reviewText) {
        Name = name;
        Date = date;
        ReviewText = reviewText;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getReviewText() {
        return ReviewText;
    }

    public void setReviewText(String reviewText) {
        ReviewText = reviewText;
    }
}
