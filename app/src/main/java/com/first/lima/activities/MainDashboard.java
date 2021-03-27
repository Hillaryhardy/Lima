package com.first.lima.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

import com.first.lima.R;
import com.first.lima.activities.farmer.CountyList;
import com.first.lima.activities.farmer.onboardingfarmer.OnBoardingFarmer;
import com.first.lima.activities.landowner.LandForm;
import com.first.lima.activities.landowner.onboarding.OnBoarding;

public class MainDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
    }

    public void farmer(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainDashboard.this);
        dialog.setCancelable(true);
        dialog.setTitle("Welcome to Lima");
        dialog.setMessage("This is the Farmer Activity");
        dialog.setPositiveButton(Html.fromHtml("<font color='#0737d4'>Proceed</font>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainDashboard.this, OnBoardingFarmer.class);
                startActivity(intent);
            }
        });
        dialog.setNegativeButton(android.R.string.no,null).show();

    }
    public void landowner(View v){

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainDashboard.this);
        dialog.setCancelable(true);
        dialog.setTitle("Welcome to Lima");
        dialog.setMessage("This is the Land Owner Activity");
        dialog.setPositiveButton(Html.fromHtml("<font color='#0737d4'>Proceed</font>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainDashboard.this, OnBoarding.class);
                startActivity(intent);
            }
        });
        dialog.setNegativeButton(android.R.string.no,null).show();
    }

}
