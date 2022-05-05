package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class progress extends AppCompatActivity {
    int e1,e2,e3,e4,e5,e6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        e1=0;
        e2=0;
        e3=0;
        e4=0;
        e5=0;
        e6=0;
    }

    public void back(View v){
        Intent back = new Intent(getApplicationContext(), Home.class);
        startActivity(back);
    }
    public void gotoInfo(View v){
        Intent inf = new Intent(getApplicationContext(), Info.class);
        startActivity(inf);
    }
    public void rated(View v){
        //send POST to the database to save the user's rating

    }
    //POST to tell the db which episode is watched and which is not
    public void watched1(View v){
        if(e1==0){
            Toast.makeText(this, "Episode1 Watched", Toast.LENGTH_SHORT).show();
            e1=1;
        }
        else {
            Toast.makeText(this, "Episode1 marked as NotWatched", Toast.LENGTH_SHORT).show();
            e1=0;
        }
    }
    //POST to tell the db which episode is watched and which is not
    public void watched2(View v){
        if(e2==0){
            Toast.makeText(this, "Episode2 Watched", Toast.LENGTH_SHORT).show();
            e2=1;
        }
        else {
            Toast.makeText(this, "Episode2 marked as NotWatched", Toast.LENGTH_SHORT).show();
            e2=0;
        }
    }
    //POST to tell the db which episode is watched and which is not
    public void watched3(View v){
        if(e3==0){
            Toast.makeText(this, "Episode3 Watched", Toast.LENGTH_SHORT).show();
            e3=1;
        }
        else {
            Toast.makeText(this, "Episode3 marked as NotWatched", Toast.LENGTH_SHORT).show();
            e3=0;
        }
    }
    //POST to tell the db which episode is watched and which is not
    public void watched4(View v){
        if(e4==0){
            Toast.makeText(this, "Episode4 Watched", Toast.LENGTH_SHORT).show();
            e4=1;
        }
        else {
            Toast.makeText(this, "Episode4 marked as NotWatched", Toast.LENGTH_SHORT).show();
            e4=0;
        }
    }
    //POST to tell the db which episode is watched and which is not
    public void watched5(View v){
        if(e5==0){
            Toast.makeText(this, "Episode5 Watched", Toast.LENGTH_SHORT).show();
            e5=1;
        }
        else {
            Toast.makeText(this, "Episode5 marked as NotWatched", Toast.LENGTH_SHORT).show();
            e5=0;
        }
    }
    //POST to tell the db which episode is watched and which is not
    public void watched6(View v){
        if(e6==0){
            Toast.makeText(this, "Episode6 Watched", Toast.LENGTH_SHORT).show();
            e6=1;
        }
        else {
            Toast.makeText(this, "Episode6 marked as NotWatched", Toast.LENGTH_SHORT).show();
            e6=0;
        }
    }

}