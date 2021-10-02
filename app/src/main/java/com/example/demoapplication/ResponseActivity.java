package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResponseActivity extends AppCompatActivity {

    TextView responseResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        responseResult = findViewById(R.id.tv_response);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
               // .baseUrl("https://easychat-dev.allincall.in/chat/webhook/et-source/welcome-message/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        Call<List<Post>> call = jsonPlaceHolder.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
              if(!response.isSuccessful()){
                  responseResult.setText("Code:"+response.code());
                  return;
              }
             List<Post> posts =response.body();
              for(Post post :posts){
                  String content = "";
                  content +="ID:"+ post.getId()+"\n";
                  content +="User ID:"+ post.getUserId()+"\n";
                  content +="Title:"+ post.getTitle()+"\n";
                  content +="Text:"+ post.getText()+"\n\n";

                  responseResult.append(content);

              }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
               responseResult.setText(t.getMessage());
            }
        });
    }
}