package com.example.medimine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {
    private String[][] details1=
            {
                    {"Doctor Name : Ravi Bhatia","Hospital Address : Noida","Experience  10yrs","Mobile no. : 9457876874","Emolument    1000"},
                    {"Doctor Name : Raj  Agarwal","Hospital Address : G.Noida","Experience   7yrs","Mobile no. : 7078515021","Emolument    800"},
                    {"Doctor Name : Parth Kumar","Hospital Address : Delhi","Experience   3yrs","Mobile no. : 9456623570","Emolument    700"},
                    {"Doctor Name : Renu Singh","Hospital Address : Jaipur","Experience   2yrs","Mobile no. : 6396021563","Emolument    600"},
                    {"Doctor Name : Anju Gupta","Hospital Address : Kanpur","Experience  10yrs","Mobile no. : 8398832257","Emolument    900"},
                    {"Doctor Name : Ved Rana","Hospital Address : Merrut","Experience  8yrs","Mobile no. : 8937896146","Emolument    1000"},
                    {"Doctor Name : Rani Sharma","Hospital Address : Ghaziabad","Experience   7yrs","Mobile no. : 972012205","Emolument    1000"},
            };
    private String[][] details2=
            {
                    {"Doctor Name : Manav Gupta","Hospital Address : Noida","Experience   5yrs","Mobile no. : 9457566874","Emolument    1000"},
                    {"Doctor Name : kuanl Raj","Hospital Address : G.Noida","Experience  6yrs","Mobile no. : 7078775021","Emolument    800"},
                    {"Doctor Name : Prem Kumar","Hospital Address : Delhi","Experience  10yrs","Mobile no. : 9456678570","Emolument    700"},
                    {"Doctor Name : Rohit Sharma","Hospital Address : Jaipur","Experience  10yrs","Mobile no. : 63945021563","Emolument    600"},
                    {"Doctor Name : Atul Sharma","Hospital Address : Kanpur","Experience  8yrs","Mobile no. : 8398834257","Emolument    900"},
                    {"Doctor Name :  Harsh Chauhan","Hospital Address : Merrut","Experience   7yrs","Mobile no. : 8921896146","Emolument    1000"},
                    {"Doctor Name : Abhishek chaudhary","Hospital Address : Ghaziabad","Experience   7yrs","Mobile no. : 9220146605","Emolument    1000"},
            };
    private String[][] details3=
            {
                    {"Doctor Name : Paras Saini","Hospital Address : Noida","Experience  10yrs","Mobile no. : 9457871174","Emolument    1000"},
                    {"Doctor Name : Yash Yadav","Hospital Address : G.Noida","Experience   7yrs","Mobile no. : 7078512121","Emolument    800"},
                    {"Doctor Name : Gaurav Singh","Hospital Address : Delhi","Experience  6yrs","Mobile no. : 9456622270","Emolument    700"},
                    {"Doctor Name : Nilay Shukla","Hospital Address : Jaipur","Experience   7yrs","Mobile no. : 6396027763","Emolument    600"},
                    {"Doctor Name :  Tarun kumar","Hospital Address : Kanpur","Experience  10yrs","Mobile no. : 8398866257","Emolument    900"},
                    {"Doctor Name : Akash Yadav","Hospital Address : Merrut","Experience  10yrs","Mobile no. : 8937875146","Emolument    1000"},
                    {"Doctor Name : Aman Yadav","Hospital Address : Ghaziabad","Experience   7yrs","Mobile no. : 9720775205","Emolument    1000"},
            };
    private String[][] details4=
            {
                    {"Doctor Name : Satyam Kumar","Hospital Address : Noida","Experience  10yrs","Mobile no. : 9457873274","Emolument    10000"},
                    {"Doctor Name : Richa Rajput","Hospital Address : G.Noida","Experience   7yrs","Mobile no. : 7078554021","Emolument    8000"},
                    {"Doctor Name : Sneha Rawat","Hospital Address : Delhi","Experience  10yrs","Mobile no. : 9456623554","Emolument    7000"},
                    {"Doctor Name : Niranjan raj","Hospital Address : Jaipur","Experience  10yrs","Mobile no. : 6396026863","Emolument    6000"},
                    {"Doctor Name : Nikhil Sharma","Hospital Address : Kanpur","Experience  10yrs","Mobile no. : 8398262257","Emolument    9000"},
                    {"Doctor Name : Muaz Ansari","Hospital Address : Merrut","Experience  8yrs","Mobile no. : 8937896416","Emolument    10000"},
                    {"Doctor Name : Sarthak Bhasin","Hospital Address : Ghaziabad","Experience   7yrs","Mobile no. : 953012205","Emolument    10000"},
            };
    private String[][] details5=
            {
                    {"Doctor Name : Deepansh Gupta","Hospital Address : Noida","Experience  10yrs","Mobile no. : 9457864687","Emolument    1000"},
                    {"Doctor Name : Divya Sharma","Hospital Address : G.Noida","Experience   7yrs","Mobile no. : 7078511021","Emolument    800"},
                    {"Doctor Name : Sweta Sharma","Hospital Address : Delhi","Experience  9yrs","Mobile no. : 8856623570","Emolument    700"},
                    {"Doctor Name : Ankur Dixit","Hospital Address : Jaipur","Experience  9yrs","Mobile no. : 8996021563","Emolument    600"},
                    {"Doctor Name : Mohit Thakur","Hospital Address : Kanpur","Experience  10yrs","Mobile no. : 9698832257","Emolument    900"},
                    {"Doctor Name : Ankit Agarwal","Hospital Address : Merrut","Experience  10yrs","Mobile no. : 9737896146","Emolument    1000"},
                    {"Doctor Name :  Priya K.","Hospital Address : Ghaziabad","Experience  10yrs","Mobile no. : 882012205","Emolument    1000"},
            };

TextView tv;

String[][] details={};
HashMap<String,String>item;
ArrayList list;
SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    tv= findViewById(R.id.DetailTitle3);

        Intent it= getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Dentist")==0)
            details=details1;
        else
        if (title.compareTo("Cardiologist")==0)
            details=details2;
        else
        if (title.compareTo("Dietitian")==0)
            details=details3;
        else
        if (title.compareTo("Surgeon")==0)
            details=details4;
        else
            details=details5;



        list =new ArrayList();
        for (int i=0;i<details.length;i++){
            item = new HashMap<String,String>();
        item.put("line1",details[i][0]);
            item.put("line2",details[i][1]);
            item.put("line3",details[i][2]);
            item.put("line4",details[i][3]);
            item.put("line5",details[i][4]);
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.List_ViewDD);
        lst.setAdapter(sa);
    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent it = new Intent(DetailActivity.this, BookappointmentActivity.class);
            it.putExtra("text1",title);
            it.putExtra("text2",details[i][0]);
            it.putExtra("text3",details[i][1]);
            it.putExtra("text4",details[i][3]);
            startActivity(it);
        }
    });


    }

}