package com.example.gangasnair.letsgo;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Details extends AppCompatActivity {


    TextView fromTitle,fromDescription;
    ImageView fromImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        fromTitle= findViewById(R.id.fromTitle);
        fromDescription =findViewById(R.id.fromDescription);
        fromImage =findViewById(R.id.fromImage);

    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }

    public void execute(String[] args) {
        JSONObject distance = null;

        Distance task = new Distance();
        try {

            distance = task.execute(args).get();

        } catch (InterruptedException iex) {
            iex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        try {


            JSONArray stops = distance.getJSONArray("stops");


            JSONObject from = stops.getJSONObject(1);
            String fromCity = from.getString("city");
            JSONObject obj=from.getJSONObject("wikipedia");
            String img =obj.getString("image");
            String des =obj.getString("abstract");





            fromTitle.setText(fromCity);
            fromDescription.setText(des);
            fromImage.setImageBitmap(getBitmapFromURL(img));


        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }
    }



}


