package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    //Go to the search page to search for other users and see their ratings
    public void goToSearch(View v){
        Intent searchInt = new Intent(getApplicationContext(),SearchPg.class);
        startActivity(searchInt);
    }
    //go to your Profile page
    public void goToProfile(View v){
        Intent profInt = new Intent(getApplicationContext(),Profile.class);
        startActivity(profInt);
    }
    public void info(View v){

        Intent in = new Intent(getApplicationContext(), info.class);
        startActivity(in);

    }
}