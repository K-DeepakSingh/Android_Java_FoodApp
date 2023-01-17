package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Pizza extends AppCompatActivity {

    Items d=new Items();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        ImageView image=findViewById(R.id.pizza1);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup1 = new PopupMenu(Pizza.this, image);
                popup1.getMenuInflater().inflate(R.menu.menu2, popup1.getMenu());
                popup1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Pizza.this,"Pizza Sucessfully added",Toast.LENGTH_LONG).show();
                        d.addToCart("Margretta pizzza",500);
                        return true;
                    }
                });
                popup1.show();
            }
        });
        registerForContextMenu(image);


        ImageView image2=findViewById(R.id.pizza2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup2 = new PopupMenu(Pizza.this, image);
                popup2.getMenuInflater().inflate(R.menu.menu2, popup2.getMenu());
                popup2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        Intent intent = new Intent();
                        Toast.makeText(Pizza.this," pizza added",Toast.LENGTH_LONG).show();
                        d.addToCart("Cheeze corn pizza",400);
                        return true;
                    }
                });
                popup2.show();
            }
        });
        registerForContextMenu(image2);


        ImageView image3=findViewById(R.id.pizza3);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup3 = new PopupMenu(Pizza.this, image);
                popup3.getMenuInflater().inflate(R.menu.menu2, popup3.getMenu());
                popup3.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
//                        Intent intent = new Intent();
                        Toast.makeText(Pizza.this,"pizza added",Toast.LENGTH_LONG).show();
                        d.addToCart("Capsicum paneer pizza",450);
                        return true;
                    }
                });
                popup3.show();
            }
        });
        registerForContextMenu(image3);
        ImageView image4=findViewById(R.id.pizza4);
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup4 = new PopupMenu(Pizza.this, image);
                popup4.getMenuInflater().inflate(R.menu.menu2, popup4.getMenu());
                popup4.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Pizza.this,"pizza added",Toast.LENGTH_LONG).show();
                        d.addToCart("Red sauce chilli pizza",450);
                        return true;
                    }
                });
                popup4.show();
            }
        });
        registerForContextMenu(image4);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        //menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Customize");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Customize") {
            Intent intent = new Intent(Pizza.this,Cart.class);
//            intent.setAction("android.intent.action.i5");
            startActivity(intent);
        }
        return true;
    }


}