package com.example.gangasnair.letsgo;


import android.content.DialogInterface;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    TextView fromView,toView,distanceView;
    Button fromButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromButton = findViewById(R.id.btn_from);
        String fromCity = "Thiruvananthapuram";
        String toCity = "Bangalore";
        fromView = findViewById(R.id.fromCity);
        toView = findViewById(R.id.toCity);
        distanceView = findViewById(R.id.distance);


        execute(new String[]{fromCity,toCity});
        onFromButtonPressed();
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


            JSONObject from = stops.getJSONObject(0);
            JSONObject to = stops.getJSONObject(1);


                String fromCity = from.getString("city");
          String toCity = to.getString("city");
       Double dist = distance.getDouble("distance");

            fromView.setText(fromCity);
            toView.setText(toCity);
            fromButton.setText(toCity);
           distanceView.setText(dist.toString());

        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void search(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialogView=inflater.inflate(R.layout.layout_search,null);
        builder.setView(dialogView);
        final EditText fromCitySearch=dialogView.findViewById(R.id.fromCitySearch);
        final EditText toCitySearch=dialogView.findViewById(R.id.toCitySearch);
        builder.setTitle("Search");
        builder.setMessage("Enter the cities to be searched for distance");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String fromCity=fromCitySearch.getText().toString();
                String toCity=toCitySearch.getText().toString();

                execute(new String[]{fromCity,toCity});
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        AlertDialog alert=builder.create();
        alert.show();
    }


    public void onFromButtonPressed() {
        fromButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Details.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_go, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.search) {
            search();
        }

        return super.onOptionsItemSelected(item);
    }
}

