package com.example.smallapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {

    TextView Tv_sign;
    EditText et_Email,et_Password;
    Button Bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Tv_sign=findViewById(R.id.Tv_sign);
        et_Email=findViewById(R.id.et_Email);
        et_Password=findViewById(R.id.et_Password);
        Bt_login=findViewById(R.id.Bt_login);


        Tv_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Login.this,SignUp.class);
                startActivity(i);finish();
            }
        });

        Bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = et_Email.getText().toString();
                String pass = et_Password.getText().toString();

                if (email.isEmpty()){
                    Toast.makeText(Login.this,"Please Enter Email",Toast.LENGTH_SHORT).show();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(Login.this,"Please Enter Correct Email",Toast.LENGTH_SHORT).show();

                } else if (pass.isEmpty() || pass.length()<4){
                    Toast.makeText(Login.this,"Please Enter Password at least 4 Char.",Toast.LENGTH_SHORT).show();

                } else {
                   Loginuser(email,pass);
                }
            }
        });

    }


    private void Loginuser(String email,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apiInterface = retrofit.create(Api.class);

        try {
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("email", email);
            requestBody.put("password", password);
            Call<Object> call=apiInterface.userlogin(requestBody);
            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    try {
                        if(response.code() ==200) {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String token = object.optString("token");

                            Toast.makeText(Login.this, "Login Sucess!", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(Login.this,MainActivity.class);
                            startActivity(i);
                            finish();

                        }else{
                            Toast.makeText(Login.this, "Only defined registration succeed user !", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* private void Loginuser(String email,String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);


        Call<SignLogResponce> call = api.userlogin(email, password);


        call.enqueue(new Callback<SignLogResponce>() {
            @Override
            public void onResponse(@NonNull Call<SignLogResponce> call, @NonNull Response<SignLogResponce> response) {

                if (response.code() == 200) {
                    assert response.body() != null;

                    Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                } else if (response.code() == 401) {

                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(Login.this, "Error1*", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SignLogResponce> call, @NonNull Throwable t) {

                Toast.makeText(Login.this, "Exception" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}