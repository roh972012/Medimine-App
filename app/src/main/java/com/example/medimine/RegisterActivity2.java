package com.example.medimine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {


    EditText edUsername,edEmail,edPassword,edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        edUsername= findViewById(R.id.editTextappTextFullName);
        edEmail=findViewById(R.id.editTextRegTextEmailAddress);
        edPassword= findViewById(R.id.editTextAppTextContact);
        edConfirm= findViewById(R.id.editTextAppTextFee);
        btn= findViewById(R.id.buttonApp);
        tv= findViewById(R.id.textViewExistUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity2.this,loginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = edUsername.getText().toString();
                String Email = edEmail.getText().toString();
                String Password = edPassword.getText().toString();
                String Confirm = edConfirm.getText().toString();
                database db= new database(getApplicationContext(),"medimine",null,1);
                if (Username.length() == 0 || Password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "all fields are mandatory", Toast.LENGTH_LONG).show();
            } else{
                    if (Password.compareTo(Confirm)==0){
                    if (isValid(Password)){
db.register(Username,Email,Password);
                        Toast.makeText(getApplicationContext(), "Register Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity2.this,loginActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(), "Password must Contain 8 character,having Letter,Digit and Symbol", Toast.LENGTH_LONG).show();
                    }
                    }else{
                        Toast.makeText(getApplicationContext(), "Password didn't Match", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            });

    }
public static boolean isValid(String Passwordhere){
        int f1=0,f2=0,f3=0;
        if (Passwordhere.length()<8){
            return false;
        }else{
            for (int i=0; i<Passwordhere.length();i++){
                if (Character.isLetter(Passwordhere.charAt(i))){
            f1=1;
                }
            }for (int j=0;j<Passwordhere.length();j++){
                if (Character.isDigit(Passwordhere.charAt(j))){
                    f2=1;
                }
            }for (int k=0;k<Passwordhere.length();k++){
                char c= Passwordhere.charAt(k);
                if (c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
        }if (f1==1&& f2==1 &&f3==1)
            return true;
        return false;
}

}
