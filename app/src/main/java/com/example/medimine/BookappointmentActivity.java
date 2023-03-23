package com.example.medimine;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.jar.Attributes;

public class BookappointmentActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,editDate;
TextView tv;
private DatePickerDialog datePickerDialog;
private Button DateButton,BtnBook;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookappointment);

        tv = findViewById(R.id.textView23);
        ed1 = findViewById(R.id.editTextappTextFullName);
        ed2 = findViewById(R.id.editTextAppTextAppAddress);
        ed3 = findViewById(R.id.editTextAppTextContact);
editDate=findViewById(R.id.editTextDate);
        DateButton = findViewById(R.id.imageButton);
        BtnBook = findViewById(R.id.buttonApp);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String FullName = it.getStringExtra("text2");
        String Address = it.getStringExtra("text3");
        String Contact = it.getStringExtra("text4");

        tv.setText(title);
        ed1.setText(FullName);
        ed2.setText(Address);
        ed3.setText(Contact);

        initDatePicker();

        DateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });
        BtnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                editDate.setText(i2+"/"+i1+"/"+i);
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