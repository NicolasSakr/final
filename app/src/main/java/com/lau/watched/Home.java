package com.lau.watched;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Home extends AppCompatActivity {



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
                String ovr = json.getString("overview");
                String cast = json.getString("cast");
                String rate = json.getString("rating");

            }catch(Exception e){
                e.printStackTrace();
            }

        }

    }

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
            String url = "http://localhost/lau_final/get_loki.php";
            MainActivity.DownloadTask task = new MainActivity.DownloadTask();
            task.execute(url);
            in.putExtra("title","Loki");
        }
        else if(x==1){
            //then the user clicked on "Moon Knight"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
            String url = "http://localhost/lau_final/get_moonk.php";
            MainActivity.DownloadTask task = new MainActivity.DownloadTask();
            task.execute(url);
            in.putExtra("title","MoonKnight");
        }
        else if(x==2){
            //then the user clicked on "WandaVision"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
            String url = "http://localhost/lau_final/get_wanda.php";
            MainActivity.DownloadTask task = new MainActivity.DownloadTask();
            task.execute(url);
            in.putExtra("title","WandaVision");
        }
        else if(x==3){
            //then the user clicked on "Dexter"
            //GET from the database the info about this specific tv Show
            //and send them to the Info page through the Intent
            String url = "http://localhost/lau_final/get_dex.php";
            MainActivity.DownloadTask task = new MainActivity.DownloadTask();
            task.execute(url);
            in.putExtra("title","Dexter: New Blood");
        }
        else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        //In the end when we check all teh cases we will activate it to get us to the next page
        startActivity(in);

    }
}