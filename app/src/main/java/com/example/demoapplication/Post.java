package com.example.demoapplication;

import com.google.gson.annotations.SerializedName;

public class Post {

    private int userID;
    private int id;
    private String title;
    private String text;

    public int getUserId() {
        return userID;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
   @SerializedName("body")
    public String getText() {
        return text;
    }
}
