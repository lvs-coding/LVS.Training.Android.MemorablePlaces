package com.lvsandroid.memorableplaces;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    Intent mIntent;

    ListView listView;
    static ArrayList<String> places;
    static ArrayList<LatLng> locations;
    static ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String addNewPlace = getResources().getString(R.string.add_new_place);

        // Back previous activity button
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        listView = (ListView)findViewById(R.id.lstPlaces);
        places = new ArrayList<String>(asList(addNewPlace));

        locations = new ArrayList<>();
        locations.add(new LatLng(0,0));

        myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,places);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                mIntent = new Intent(getApplicationContext(),MapsActivity.class);
                mIntent.putExtra("locationInfo",position);
                startActivity(mIntent);
            }
        });

    }

    public void changeActivity() {
        startActivity(mIntent);
    }
}
