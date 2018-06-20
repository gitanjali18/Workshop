package com.example.gangasnair.letsgo;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class Distance extends AsyncTask<String , Void , JSONObject> {

    private String URL = "https://www.distance24.org/route.json?";


    @Override
    protected JSONObject doInBackground(String... strings) {
        Uri uri;


            uri = Uri.parse(URL).buildUpon()
                    .appendQueryParameter("stops" ,strings[0]+"|"+ strings[1])
                    .build();

        HttpURLConnection connection = null;
        InputStream is = null;

        try {
            java.net.URL url = new java.net.URL(uri.toString());

            connection = (HttpURLConnection) url.openConnection();
            is = connection.getInputStream();

            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            JSONObject obj = new JSONObject(buffer.toString());
            return obj;
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        catch (IOException iex) {
            iex.printStackTrace();
        }
        catch (JSONException jex) {
            jex.printStackTrace();
        }
        finally {
            try {
                is.close();
                connection.disconnect();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}

