package com.example.medimine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String Username = sharedPreferences.getString("Username", "").toString();
        Toast.makeText(getApplicationContext(), "Welcome" + Username, Toast.LENGTH_SHORT).show();

        CardView CardExit = findViewById(R.id.CardExit);
        CardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this, loginActivity.class));
            }
        });

        CardView Doctor = findViewById(R.id.FindDoctor);
        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DoctorActivity.class));
            }
        });

        CardView LabTest = findViewById(R.id.LabTest);
        LabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });


        CardView Shop = findViewById(R.id.Shopping);
        Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ShoppingActivity.class));
            }
        });

        CardView Medicine = findViewById(R.id.Medicine);
        Medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MedicineActivity.class));
            }
        });
    }
}