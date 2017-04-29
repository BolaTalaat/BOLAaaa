//,mnmjk,bnmb n
package com.example.bola.bolaaaa;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    EditText username,password;
    Button button;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //kjksdjvjkszjnjkfff
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.button);

        sp=getSharedPreferences("login",MODE_PRIVATE);

        //if SharedPreferences contains username and password then directly redirect to Home activity
        if(sp.contains("username") && sp.contains("password")){
            startActivity(new Intent(MainActivity.this,Home.class));
            finish();   //finish current activity
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginCheck();
            }
        });
    }

    void loginCheck(){
        //check username and password are correct and then add them to SharedPreferences
       // if
        // (username.getText().toString().equals("username") && password.getText().toString().equals("password")){
            SharedPreferences.Editor e=sp.edit();
            e.putString("username",username.getText().toString());
            e.putString("password",password.getText().toString());
            e.commit();

            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_LONG).show();

            startActivity(new Intent(MainActivity.this,Home.class));
            finish();
        }
       // else{
          //  Toast.makeText(MainActivity.this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
  //  }
//}
