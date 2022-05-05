package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SearchPg extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pg);
        result = (TextView) findViewById(R.id.resultTxt);
    }
    //Go to the search page to search for movies
    public void goToHome(View v){
        Intent homeInt = new Intent(getApplicationContext(),Home.class);
        startActivity(homeInt);
    }
    //go to the Profile page
    public void goToProfile(View v){
        Intent profInt = new Intent(getApplicationContext(),Profile.class);
        startActivity(profInt);
    }
    String s ="";
    public void horrorClick(View v){
        //get all horror movies from db
        //save these values in variable s
        result.setText(s);
    }
    public void dramaClick(View v){
        //get all drama movies from db
        //save these values in variable s
        result.setText(s);
    }
    public void thrillerClick(View v){
        //get all thriller movies from db
        //save these values in variable s
        result.setText(s);
    }
    public void actionClick(View v){
        //get all action movies from db
        //save these values in variable s
        result.setText(s);
    }
}