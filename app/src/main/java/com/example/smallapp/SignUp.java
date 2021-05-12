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

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

    TextView Tv_login;
    EditText et_Name,et_Email,et_Password;
    Button Bt_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Tv_login=findViewById(R.id.Tv_login);
        et_Name=findViewById(R.id.et_Name);
        et_Email=findViewById(R.id.et_Email);
        et_Password=findViewById(R.id.et_Password);
        Bt_signup=findViewById(R.id.Bt_signup);

        Tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(SignUp.this,Login.class);
                startActivity(i);finish();
            }
        });

        Bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et_Name.getText().toString();
                String email = et_Email.getText().toString();
                String pass = et_Password.getText().toString();

                if (name.isEmpty()){
                    Toast.makeText(SignUp.this,"Please Enter Name",Toast.LENGTH_SHORT).show();

                } else if (email.isEmpty()){
                    Toast.makeText(SignUp.this,"Please Enter Email",Toast.LENGTH_SHORT).show();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(SignUp.this,"Please Enter Correct Email",Toast.LENGTH_SHORT).show();

                } else if (pass.isEmpty() || pass.length()<4){
                    Toast.makeText(SignUp.this,"Please Enter Password at least 4 Char.",Toast.LENGTH_SHORT).show();

                } else {
                    Signupuser(email,pass);
                }
            }
        });

    }


    private void Signupuser(String email,String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api apiInterface = retrofit.create(Api.class);

        try {
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("email", email);
            requestBody.put("password", password);
            Call<Object> call = apiInterface.userSign(requestBody);
            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    try {
                        if (response.code() == 200) {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String token = object.optString("token");


                            Toast.makeText(SignUp.this, "Register Sucess!", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(SignUp.this,Login.class);
                            startActivity(i);
                            finish();

                        } else {
                            Toast.makeText(SignUp.this, "Invalid Username and Email!", Toast.LENGTH_SHORT).show();
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
}