package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
    }
    public void btnOnClick(View v){
        //add the information to the database

        //login to the next page
        Intent intent = new Intent(getApplicationContext(), Home.class);
        startActivity(intent);
    }
}