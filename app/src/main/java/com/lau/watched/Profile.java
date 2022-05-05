package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView tel, name, email, fav;
    ScrollView scrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tel = (TextView) findViewById(R.id.telInfo);
        name = (TextView) findViewById(R.id.nameInfo);
        email = (TextView) findViewById(R.id.emailInfo);
        fav = (TextView) findViewById(R.id.favInfo);
        scrl = (ScrollView) findViewById(R.id.scrollView);

        //On Create, this page should fetch the info about the user
        //and fill them in the corresponding Txt views.
        tel.setText("");
        name.setText("");
        email.setText("");
        fav.setText("");
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