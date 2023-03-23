package com.example.medimine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabDetailActivity extends AppCompatActivity {
TextView tvPackageName;
EditText edPackageDetail;
Button btnAddCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_detail);

       tvPackageName = findViewById(R.id.DetailTitle55);
edPackageDetail=findViewById(R.id.editTextMultiline);
btnAddCart =findViewById(R.id.buttonAddCartlab);


edPackageDetail.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edPackageDetail.setText(intent.getStringExtra("text2"));

        btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("Username", "").toString();
                String product = tvPackageName.getText().toString();
float price = Float.parseFloat(intent.getStringExtra("text3".toString()));
                database db = new database(getApplicationContext(), "medimine", null, 1);
                if (db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                } else {
db.addCart(username,product, price ,"lab");
                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabDetailActivity.this,LabTestActivity.class));
                }
            }


        });
    }
}