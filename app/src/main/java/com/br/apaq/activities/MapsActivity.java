package com.br.apaq.activities;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.br.apaq.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;


import java.util.List;

public class MapsActivity extends Activity {

    private GoogleMap mMap;

    LatLng arenaLocation;
    GoogleMap map;
    List<LatLng> locale;
    protected android.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_map);

        //setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
/*
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
*/

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map_container)).getMap();

        arenaLocation = new LatLng(-3.736409, -38.490505);

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(true);
        //map.getUiSettings().setZoomGesturesEnabled(true);
        map.getUiSettings().setCompassEnabled(true);
        map.getUiSettings().setMyLocationButtonEnabled(true);
        //CameraUpdate update = CameraUpdateFactory.newLatLngZoom(arenaLocation, 130);
        //map.moveCamera(update);

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(arenaLocation, 10));
        map.addMarker(new MarkerOptions().position(arenaLocation)
                .title("APAQ")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.logo)));
        map.setOnMyLocationChangeListener(listener);

    }

    private GoogleMap.OnMyLocationChangeListener listener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {

            // Toast.makeText(getApplicationContext(), location.getLatitude() + " "
            //         + location.getLongitude() + ""
            //         + location.getAltitude(),Toast.LENGTH_LONG).show();

            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.add(arenaLocation);
            polylineOptions.add(new LatLng(location.getLatitude(), location.getLongitude()));
            map.addPolyline(polylineOptions);


        }
    };

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    //@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apaq_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
