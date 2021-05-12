package com.example.smallapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmiCalculator extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterRecycle adapterRecycle;
    List<Model> data = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calculator);

        recyclerView = findViewById(R.id.Recyclerviewid);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(EmiCalculator.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        listData();

    }

    private void listData() {

        for (int i = 1; i < 20; i++) {

            data.add(new Model("1 yr", "₹ 14,879", "₹ 4,586", "₹ 19,465"));
            data.add(new Model("2 yr", "₹ 16,600", "₹ 2,865", "₹ 19,465"));
            data.add(new Model("3 yr", "₹ 16,899", "₹ 944", "₹ 17,843"));
            data.add(new Model("4 yr", "₹ 17,899", "₹ 744", "₹ 18,843"));

            adapterRecycle = new AdapterRecycle(data, this);
            recyclerView.setAdapter(adapterRecycle);
            adapterRecycle.notifyDataSetChanged();

        }

    }
}