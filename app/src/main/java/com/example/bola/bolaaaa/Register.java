package com.example.bola.bolaaaa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText email,username,password,confirmPassword;
    Button BtnCreatAccount;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email= (EditText) findViewById(R.id.email);
        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        confirmPassword= (EditText) findViewById(R.id.confirmpassword);
        BtnCreatAccount= (Button) findViewById(R.id.creatacount);

        sp=getSharedPreferences("Create Account",MODE_PRIVATE);
        if(sp.contains("email")&&sp.contains("username") && sp.contains("password")&&sp.contains("confirmPassword")){
            startActivity(new Intent(Register.this,Home.class));
            finish();   //finish current activity
        }
        BtnCreatAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterCheck();
            }
        });

    }
    void RegisterCheck(){
        //check username and password are correct and then add them to SharedPreferences

        SharedPreferences.Editor e=sp.edit();
        e.putString("Email",email.getText().toString());
        e.putString("username",username.getText().toString());
        e.putString("password",password.getText().toString());
        e.putString("Confirm Password",confirmPassword.getText().toString());
        if(password.getText().toString().equals( confirmPassword.getText().toString())){
            e.commit();

            Toast.makeText(Register.this,"Register Successful",Toast.LENGTH_LONG).show();

            startActivity(new Intent(Register.this,MainActivity.class));
            finish();
        }
        else
            Toast.makeText(Register.this,"Please check your data",Toast.LENGTH_LONG).show();

    }


}
