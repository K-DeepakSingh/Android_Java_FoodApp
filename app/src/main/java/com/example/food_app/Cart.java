package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.example.food_app.Items;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Items d =new Items();
        CheckBox c1 = findViewById(R.id.c1);
        CheckBox c2 = findViewById(R.id.c2);
        CheckBox c3 = findViewById(R.id.c3);
        CheckBox c4 = findViewById(R.id.c4);
        CheckBox c5 = findViewById(R.id.c5);
        CheckBox c6 = findViewById(R.id.c6);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(c1.isChecked()){
                    d.addToCart("Extra cheese",30);
                }
                if(c2.isChecked()){
                    d.addToCart("Mayo Dip",50);
                }
                if(c3.isChecked()){
                    d.addToCart("Corn Topping",25);
                }
                if(c4.isChecked()){
                    d.addToCart("Thick Crust",49);
                }
                if(c5.isChecked()){
                    d.addToCart("Extra Paneer",45);
                }
                if(c6.isChecked()){
                    d.addToCart("Extra Chicken",55);
                }
                Intent i=new Intent(Cart.this,Cartdisplay.class);
                startActivity(i);
            }
        });
    }
}