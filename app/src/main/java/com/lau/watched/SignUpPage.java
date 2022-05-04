package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SignUpPage extends AppCompatActivity {

    EditText pass;
    EditText verifyPass;
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        pass = (EditText) findViewById(R.id.Password);
        verifyPass = (EditText) findViewById(R.id.VerifyPass);
        res = (TextView) findViewById(R.id.errorText);
    }
    public void btnOnclick(View v){
        if(verifyPass.toString() == pass.toString()){
            //add the information to the database

            //login to the next page
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
        else{
            res.setText("Passwords Don't match");
        }
    }
}