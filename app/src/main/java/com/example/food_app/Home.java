package com.example.food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "pasta is selected", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Home.this,Pasta.class);
                startActivity(i);
                return true;

            case R.id.item:
                Toast.makeText(this, "Go to the cart", Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(Home.this,Cartdisplay.class);
                startActivity(i2);
                return true;

            case R.id.item3:
                Toast.makeText(this, "veg pizza is selected", Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(Home.this,Pizza.class);
        startActivity(i1);
                return true;


            case R.id.item4:
                Toast.makeText(this, "non veg pizza is selected", Toast.LENGTH_SHORT).show();
                Intent i3=new Intent(Home.this,NonVeg.class);
        startActivity(i3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}