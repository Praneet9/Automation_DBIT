package com.example.vinay.automation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RailwayReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway_reservation);
    }

    public void newUserClicked(View view){
        Intent i = new Intent(this, NewUserRailway.class);
        startActivity(i);
    }

    public void existingUserClicked(View view){
        Intent intent = new Intent(this, ExistingUserRailway.class);
        startActivity(intent);
    }
}
