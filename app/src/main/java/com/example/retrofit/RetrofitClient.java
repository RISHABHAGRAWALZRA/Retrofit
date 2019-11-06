package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitClient {

    @GET("/posts/1")
    Call<Post> getSinglepost();

    @GET("/posts")
    Call<List<Post>> getAllposts();

    @POST("/posts")
    Call<Post> sendPost(@Body Post post);


}
