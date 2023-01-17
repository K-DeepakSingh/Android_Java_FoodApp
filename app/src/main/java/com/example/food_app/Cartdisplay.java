package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class Cartdisplay extends AppCompatActivity implements SingleDialouge.SingleChoiceListener {
    private TextView delivery;
    Items d=new Items();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartdisplay);

        delivery=findViewById(R.id.delivery);
        ListView lv1 = findViewById(R.id.l);
        ListView lv2 = findViewById(R.id.l2);
        ArrayList<String> i = d.get_namea();
        ArrayList<Integer> i2 = d.get_pricea();

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Food App Notification"," Food App Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, i);
        ArrayAdapter<Integer> itemsAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, i2);
        lv1.setAdapter(itemsAdapter);
        lv2.setAdapter(itemsAdapter2);

        int tot = 0;
        if (i2.size() != 0) {
            for (int q : i2) {
                tot += q;
            }
        }
        EditText t = findViewById(R.id.total);
        t.setText("Total Cost : " + tot);
        Button btn=findViewById(R.id.order);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment singleChoiceDialog = new SingleDialouge();
                singleChoiceDialog.setCancelable(false);
                singleChoiceDialog.show(getSupportFragmentManager(), "Single Choice Dialog");
            }
        });

    }
    @Override
    public void onPositiveButtonClicked(String[] list, int position) {
        delivery.setText("Mode of Delivery= " + list[position]);
        Toast.makeText(Cartdisplay.this,"Order has been placed",Toast.LENGTH_LONG).show();
        Intent i = new Intent(Cartdisplay.this, Pending.class);
        i.putExtra("Message","The 1 -2 PM lecture has been postponed to Saturday, 3 - 4 pm");
        PendingIntent pi = PendingIntent.getActivity(Cartdisplay.this, 0, i, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(Cartdisplay.this,"Food App Notification");
        builder.setContentTitle("Order Placed Sucessfully");
        builder.setContentText("Your food is being prepared ");
        builder.setSmallIcon(R.drawable.logo);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
//        System.out.println("working");
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Cartdisplay.this);
        managerCompat.notify(0,builder.build());
//        System.out.println("working");

    }
    @Override
    public void onNegativeButtonClicked() {
        delivery.setText("");
    }

}