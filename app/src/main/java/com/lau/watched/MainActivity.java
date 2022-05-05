package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView res;


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
                String email = json.getString("email");

            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }



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
        //if(/*found*/){
        String url = "http://localhost/lau_final/get_credentials.php";
        DownloadTask task = new DownloadTask();
        task.execute(url);

            Intent intnt = new Intent(getApplicationContext(),Home.class);
            startActivity(intnt);
        //}
        //else{
        //    res.setText("Username or Password entered is not correct.");
        //}
    }
}