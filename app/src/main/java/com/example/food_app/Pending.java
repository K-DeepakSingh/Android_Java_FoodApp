package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Pending extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        Button b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i2=new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse("tel:7249582964"));
                startActivity(i2);
            }
        });
        TextView textView;

        textView = findViewById (R.id.ab);

//        Schedule a countdown until a time in the future, with regular notifications on intervals along the way. Example of showing a 50-second countdown in a text field:

        new CountDownTimer(1800000, 1000) {

            public void onTick(long millisUntilFinished) {

                // Used for formatting digit to be in 2 digits only

                NumberFormat f = new DecimalFormat("00");

                long hour = (millisUntilFinished / 3600000) % 24;

                long min = (millisUntilFinished / 60000) % 60;

                long sec = (millisUntilFinished / 1000) % 60;

                textView.setText("Just  "+f.format(hour) + ":" + f.format(min) + ":" + f.format(sec)+"  left ");

            }

            // When the task is over it will print 00:00:00 there

            public void onFinish() {

                textView.setText("00:00:00");

            }

        }.start();
    }
}