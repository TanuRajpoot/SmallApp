package com.example.smallapp;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL="https://reqres.in/api/";


    @POST("register")
    Call<Object> userSign(@Body Map<String, String> body);

    @POST("login")
    Call<Object> userlogin(@Body Map<String, String> body);

    @GET("users?page=2")
    Call<UserListResponce> userListData();

}
