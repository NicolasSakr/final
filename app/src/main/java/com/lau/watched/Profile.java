package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Profile extends AppCompatActivity {


    public static class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... urls){
            String result = "";
            URL url;
            HttpURLConnection http;

            try{
                url = new URL(urls[0]);
                http = (HttpURLConnection) url.openConnection();

                InputStream in = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while( data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }

            return result;
        }


        protected void onPostExecute(String s){
            super.onPostExecute(s);

            try{
                JSONObject json = new JSONObject(s);
                String fname = json.getString("first_name");
                String lname = json.getString("last_name");
                String email = json.getString("email");
                String phonenb = json.getString("tel_num");

            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }



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

        String url = "http://localhost/lau_final/get_use_info.php";
        MainActivity.DownloadTask task = new MainActivity.DownloadTask();
        task.execute(url);

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