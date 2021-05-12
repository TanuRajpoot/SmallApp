package com.example.smallapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VollyExample extends AppCompatActivity {

    ListView listView;
    List<ModelClssGetid.ResponseBean>  ModellistData = new ArrayList<>();;
    AdapterForList listAdapter;
    String url = "https://ravinder.eygb.me/api/v1/internships/list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volly_example);
        listView = findViewById(R.id.listId);

        VollyData();
    }

    private void VollyData() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("TAG", response.toString());

                try {
                    JSONArray jsonArray = response.getJSONArray("response");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        ModelClssGetid.ResponseBean modelClssGetid1 = new ModelClssGetid.ResponseBean();

                        modelClssGetid1.setApplication_id(jsonArray.getJSONObject(i).getString("application_id"));
                        modelClssGetid1.setTitle(jsonArray.getJSONObject(i).getString("title"));
                        modelClssGetid1.setType(jsonArray.getJSONObject(i).getString("type"));

                        ModellistData.add(modelClssGetid1);

                        listAdapter = new AdapterForList(ModellistData, getApplication(), R.layout.custm_list);
                        listView.setAdapter(listAdapter);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(VollyExample.this, "Exception" + error, Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }
}