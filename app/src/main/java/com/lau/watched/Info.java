package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    TextView ovr, rate, cast;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //assign the text views in order to get the full info on one page
        ovr = (TextView) findViewById(R.id.overview);
        rate = (TextView) findViewById(R.id.rating);
        cast = (TextView) findViewById(R.id.cast);
        img = (ImageView) findViewById(R.id.poster);

        //get info from intent
        Intent x = getIntent();
        String info = x.getStringExtra("overview");
        ovr.setText(info);
        String ratings = x.getStringExtra("lbp");
        rate.setText(ratings);
        String casts = x.getStringExtra("cast");
        cast.setText(casts);
    }

    public void back(View v){
        Intent back = new Intent(getApplicationContext(), Home.class);
        startActivity(back);
    }
    public void gotoProg(View v){
        Intent prog = new Intent(getApplicationContext(), progress.class);
        startActivity(prog);
    }
}