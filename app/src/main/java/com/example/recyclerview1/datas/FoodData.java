package com.example.recyclerview1.datas;

import com.example.recyclerview1.R;
import com.example.recyclerview1.models.Food;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FoodData {
    private static String [] foodName = {
            "Kebab Small",
            "kebab Original",
            "Kebab Large",
            "Spagetti",
            "Spagetti Hot",
            "Es Coklat"
    };

    private static String [] foodPrice = {
            "2000",
            "5000",
            "10000",
            "2000",
            "5000",
            "10000"
    };

    private static int [] foodImage = {
            R.drawable.kebab,
            R.drawable.kebab,
            R.drawable.kebab,
            R.drawable.spagettii,
            R.drawable.spagettii,
            R.drawable.es_coklat,
    };

    public static ArrayList<Food> getDataFood() {
        ArrayList<Food> list = new ArrayList<>();
        for(int i=0;i<foodName.length;i++){
            Food food = new Food(foodName[i],"Rp " + foodPrice[i], foodImage[i]);
            list.add(food);
        }
        return list;
    }
}
