package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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

        Intent in = new Intent(getApplicationContext(), Info.class);
        ImageView img = (ImageView) v;
        int x = Integer.parseInt(img.getTag().toString());

        //now all we need to do is switch on x which is the tag of the different tv shows
        //that will let us know which one we clicked to get the information about it.
        if(x==0){
            //then the user clicked on "Loki"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
        }
        else if(x==1){
            //then the user clicked on "Moon Knight"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
        }
        else if(x==2){
            //then the user clicked on "WandaVision"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
        }
        else if(x==3){
            //then the user clicked on "Dexter"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
        }
        else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        //In the end when we check all teh cases we will activate it to get us to the next page
        startActivity(in);

    }
}