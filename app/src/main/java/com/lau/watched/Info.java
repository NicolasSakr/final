package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    /*
    Intent x = getIntent();
    String lbp = x.getStringExtra("lbp");
        lb.setText(lbp + " LBP");
     */
    public void back(View v){
        Intent back = new Intent(getApplicationContext(), Home.class);
        startActivity(back);
    }
}