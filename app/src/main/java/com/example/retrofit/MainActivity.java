package com.example.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String BASE_URL="https://jsonplaceholder.typicode.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitClient retrofitClient=retrofit.create(RetrofitClient.class);
        Call<Post> getSinglepost=retrofitClient.getSinglepost();
        getSinglepost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d(TAG, "onResponse: OnGettingSinglePost: code: "+ response.code());
                Post post=response.body();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure: OnGettingSinglePost :t: "+t.getMessage());
            }
        });

        Call<List<Post>> getAllPost=retrofitClient.getAllposts();
        getAllPost.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d(TAG, "onResponse: OnGettingAllPost : code :"+response.code());
                Log.d(TAG, "onResponse: OnGettingAllPost : title :"+response.body().get(1).getTitle());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: OnGettingAllPost : t:"+t.getMessage());
            }
        });

        Call<Post> sendPost=retrofitClient.sendPost(new Post("title","body",1,1));
        sendPost.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d(TAG, "onResponse: : code :"+response.code());
                Log.d(TAG, "onResponse:  : post :"+response.body().toString());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "onFailure:  : t:"+t.getMessage());
            }
        });
    }
}
