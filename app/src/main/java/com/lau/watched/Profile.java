package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    //Go to the search page to search for movies
    public void goToHome(View v){
        Intent homeInt = new Intent(getApplicationContext(),Home.class);
        startActivity(homeInt);
    }
    //Go to the search page to search for movies
    public void goToSearch(View v){
        Intent searchInt = new Intent(getApplicationContext(),SearchPg.class);
        startActivity(searchInt);
    }
}