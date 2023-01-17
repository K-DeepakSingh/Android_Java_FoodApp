package com.example.food_app;
import android.widget.TextView;

import java.util.*;
public class Items {
    static ArrayList<String> namea=new ArrayList<>();
    static ArrayList<Integer> pricea=new ArrayList<>();

    public static void addToCart(String name,int price){
        namea.add(name);
        pricea.add(price);
    }

    public ArrayList<String> get_namea(){return namea;}
    public ArrayList<Integer> get_pricea(){return pricea;}

}

