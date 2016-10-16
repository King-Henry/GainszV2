package com.gainsz.gainsz;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;

import static android.R.attr.button;


public class MainActivity extends AppCompatActivity{

    MapFragment mapFragment;
    EditText dollars;
    EditText cents;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dollars = (EditText)findViewById(R.id.dollars);
        cents = (EditText)findViewById(R.id.cents);
        button = (Button)findViewById(R.id.proceed_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setEnabled(false);
                String stringTotal = dollars.getText().toString() + "." + cents.getText().toString();
                double doubleTotal = Double.parseDouble(stringTotal);
                Log.d("Double Total", String.format("%f" ,doubleTotal));
                Intent intent = new Intent(MainActivity.this, RestaurantList.class);
                startActivity(intent);



            }
        });
    }

}
