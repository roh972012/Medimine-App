package com.example.medimine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        CardView back= findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this, HomeActivity.class));
            }
        });

        CardView Dentist= findViewById(R.id.Dentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DetailActivity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });
        CardView Dietitian= findViewById(R.id.Dietitian);
        Dietitian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DetailActivity.class);
                it.putExtra("title", "Dietitian");
                startActivity(it);
            }
            });

        CardView Cardiologist= findViewById(R.id.Cardiologist);
        Cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DetailActivity.class);
                it.putExtra("title", "Cardiologist");
                startActivity(it);
            }
        });
        CardView Surgeon= findViewById(R.id.Surgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DetailActivity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });
        CardView Physician= findViewById(R.id.Physician);
        Physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DetailActivity.class);
                it.putExtra("title", "Physician");
                startActivity(it);
            }
        });
        }
}