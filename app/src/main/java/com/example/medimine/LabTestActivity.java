package com.example.medimine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages=
            {
                    {"Package 1: Full Body Checkup","","","","3000"},
                    {"Package 2: Diabetes","","","","700"},
                    {"Package 3: Covid -19","","","","900"},
                    {"Package 4: Thyroid","","","","600"},
                    {"Package 5: Pregnancy","","","","800"},
            };
    private String[] package_deatails ={
                    "Full Body Check Up\n"+
                    "Complete Hemogram\n"+
                    "HbA1c\n"+
                    "Kidney Function Test\n"+
                    "LDH Lactate Dehydrogenase,Serum\n"+
                    "Lapid Profile\n"+
                    "Liver Function Test",
                    "Diabetes\n"+
                    "Fasting plasma glucose test\n"+
                    "Random plasma glucose test\n"+
                    "A1C test",
                    "Covid-19 \n" +
                    "Molecular (RT-PCR) Tests\n"+
                    "COVID-19 Antigen Tests\n"+
                    "COVID-19 Antibody Tests\n"+
                    "Rapid antigen test (RAT)",
                    "Thyroid Profile - Total (T3,T4 AND TSH Ultra Sensitive)",
                    "Complete Hemogram\n"+
                    "CRP (C Reactive Protein) Quantitative, Serum\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Vitamin D Total- 25 Hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button
     buttonCart;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        buttonCart =findViewById(R.id.buttonCart);
        listview = findViewById(R.id.ListViewCC);

list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
                listview.setAdapter(sa);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent it = new Intent(LabTestActivity.this, LabDetailActivity.class);

                            it.putExtra("text1",packages[i][0]);
                            it.putExtra("text2",package_deatails[i]);
                            it.putExtra("text3",packages[i][4]);
                            startActivity(it);
                        }

                });
buttonCart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
    }
});

    }
}