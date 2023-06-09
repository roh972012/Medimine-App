package com.example.medimine;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {
HashMap<String,String>item;
ArrayList list;
SimpleAdapter sa;

private DatePickerDialog datePickerDialog;
private Button dateButton,btnCheckout;
private String[][] packages={};
EditText editCartDate,editPrice;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        dateButton = findViewById(R.id.imageButtonCart);
        editCartDate = findViewById(R.id.editTextDateCart);
        btnCheckout = findViewById(R.id.buttonAddCartAb);
        editPrice = findViewById(R.id.editTextprice);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("Username", "").toString();

        database db = new database(getApplicationContext(), "medimine", null, 1);

        float totalAmount = 0;
        ArrayList dbData = db.getCartData(username, "lab");
        Toast.makeText(getApplicationContext(), "" + dbData, Toast.LENGTH_SHORT).show();

        packages = new String[dbData.size()][];
        for (int i = 0; i < packages.length; i++) {
            packages[i] = new String[5];
        }

        for (int i = 0; i < dbData.size(); i++) {
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            packages[i][0] = strData[0];
            packages[i][4] = "cost : " + strData[1] + "/-";
            totalAmount = totalAmount + Float.parseFloat(strData[1]);

        }
        editPrice.setText("Total Cost : " + totalAmount);

        list =new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.List_ViewRR);
        lst.setAdapter(sa);

btnCheckout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefer", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("Username", "").toString();

        database db = new database(getApplicationContext(), "medimine", null, 1);

db.addOrder(username);
db.removeCart(username,"lab");
Toast.makeText(getApplicationContext(), "Booked Successfully" , Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CartLabActivity.this,HomeActivity.class));
    }
});

initDatePicker();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
    }    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                editCartDate.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month =cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_DEVICE_DEFAULT_LIGHT;
        datePickerDialog = new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
}

