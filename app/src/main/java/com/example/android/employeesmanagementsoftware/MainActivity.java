package com.example.android.employeesmanagementsoftware;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.airbnb.lottie.LottieAnimationView;
import com.example.android.employeesmanagementsoftware.DepartmentDB.DepartmentActivity;
import com.example.android.employeesmanagementsoftware.DepartmentDB.MyDepartmentRecyclerViewAdapter;
import com.example.android.employeesmanagementsoftware.data.Contracts.EmployeeContract;
import com.example.android.employeesmanagementsoftware.data.DBHelpers.EmployeesManagementDbHelper;

/*
made by Aya
 */
// see how to connect 3 main activity ** department ** employies **tasks
public class MainActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    private static int SPLASH_TIME_OUT = 8000;
    private ImageView logo;
    TextView name;
    private LottieAnimationView lott, lot_load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.im_logo);
        name = findViewById(R.id.tv_logo);
        lott = findViewById(R.id.lottie);
        lot_load = findViewById(R.id.lottie_load);


        logo.animate().translationX(1400).setDuration(1300).setStartDelay(2500);
        name.animate().translationX(-1400).setDuration(1000).setStartDelay(3000);
        lott.animate().translationX(1400).setDuration(1000).setStartDelay(4800);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                lot_load.setVisibility(View.VISIBLE);
            }
        },6000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home = new Intent(MainActivity.this,ConnexionActivity.class);
                startActivity(home);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
