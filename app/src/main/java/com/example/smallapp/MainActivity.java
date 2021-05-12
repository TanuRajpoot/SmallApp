package com.example.smallapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<UserListResponce.DataBean> listData = new ArrayList<>();
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.Listview);
        getData();
    }

    void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<UserListResponce> call = api.userListData();

        call.enqueue(new Callback<UserListResponce>() {
            @Override
            public void onResponse(@NonNull Call<UserListResponce> call, @NonNull Response<UserListResponce> response) {

                if (response.code() == 200) {
                    assert response.body() != null;

                    listData.addAll(response.body().getData());

                    listAdapter = new ListAdapter(getApplicationContext(), R.layout.custm_list, listData);
                    listView.setAdapter(listAdapter);



                } else if (response.code() == 401) {

                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserListResponce> call, @NonNull Throwable t) {

                Toast.makeText(MainActivity.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


}