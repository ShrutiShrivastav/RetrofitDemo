package com.example.demoapplication;

import java.io.PipedOutputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    //@Headers("api-key: " + "ca4fce07-1e5d-4121-91e2-53c6bd4fd0b6")
    @Headers("Content-Type: application/json")
    @GET("posts")
    Call<List<Post>> getPosts();
}
