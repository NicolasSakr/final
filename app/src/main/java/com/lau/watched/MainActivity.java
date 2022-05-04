package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (TextView) findViewById(R.id.errorText);
    }

    public void goSignUp(View view){
        Intent intent = new Intent(getApplicationContext(), SignUpPage.class);
        startActivity(intent);
    }

    public void onCLick(View v){
        //check if the username is found and the password is correct
        //if it is found: go to the Home Page
        //if not, get a message that the username or password entered is wrong
        if(found){
            Intent intnt = new Intent(getApplicationContext(),Home.class);
            startActivity(intnt);
        }
        else{
            res.setText("Username or Password entered is not correct.");
        }
    }
}