package com.example.vinay.automation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FormType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_type);
    }

    public void railwayReservationClicked(View view){
        Intent i = new Intent(this, RailwayReservation.class);
        startActivity(i);
    }

    public void ktFormClicked(View view){
        Intent intent = new Intent(this, KTForm.class);
        startActivity(intent);
    }
}
