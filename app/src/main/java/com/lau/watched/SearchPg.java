package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SearchPg extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String, Void, String> {

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
                String genre = json.getString("genre");

            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }


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
        String url = "http://localhost/lau_final/get_genre.php";
        MainActivity.DownloadTask task = new MainActivity.DownloadTask();

        result.setText(task.execute(url).toString());
    }
    public void dramaClick(View v){
        //get all drama movies from db
        //save these values in variable s
        String url = "http://localhost/lau_final/get_genre_drama.php";
        MainActivity.DownloadTask task = new MainActivity.DownloadTask();
        result.setText(task.execute(url).toString());
    }
    public void thrillerClick(View v){
        //get all thriller movies from db
        //save these values in variable s
        String url = "http://localhost/lau_final/get_genre_thriller.php";
        MainActivity.DownloadTask task = new MainActivity.DownloadTask();
        result.setText(task.execute(url).toString());
    }
    public void actionClick(View v){
        //get all action movies from db
        //save these values in variable s
        String url = "http://localhost/lau_final/get_genre_action.php";
        MainActivity.DownloadTask task = new MainActivity.DownloadTask();
        result.setText(task.execute(url).toString());
    }
}