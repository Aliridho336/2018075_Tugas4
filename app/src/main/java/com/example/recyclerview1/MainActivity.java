package com.example.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerview1.adapters.FoodAdapter;
import com.example.recyclerview1.datas.FoodData;
import com.example.recyclerview1.models.Food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvFood;
    public List<Food> foodList = new ArrayList<>();
    int pilihan = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Foods");

        rvFood = findViewById(R.id.rv_food);

        foodList = FoodData.getDataFood();
        FoodAdapter foodAdapter = new FoodAdapter(foodList);

        rvFood.setAdapter(foodAdapter);
        rvFood.setLayoutManager(new LinearLayoutManager(this));

        rvFood.addItemDecoration(new DividerItemDecoration
                (this, DividerItemDecoration.VERTICAL));

        foodAdapter.setOnItemClickCallback(new FoodAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Food data) {
                if(pilihan == 1) {
                    rvFood.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
                    pilihan = 2;
                } else if(pilihan == 2) {
                    rvFood.setLayoutManager(new StaggeredGridLayoutManager(2,
                            StaggeredGridLayoutManager.VERTICAL));
                }
            }
        });
    }

    private void showSelectedFood(Food data) {
        Toast.makeText(this, "Kamu memilih " + data.getName(), Toast.LENGTH_SHORT).show();
    }
}