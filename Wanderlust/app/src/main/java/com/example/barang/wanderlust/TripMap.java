package com.example.barang.wanderlust;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.support.constraint.Constraints.TAG;

public class TripMap extends AppCompatActivity implements OnMapReadyCallback {

    DatabaseHelper myDatabaseHelper;
    private GoogleMap mMap;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_map);

        myDatabaseHelper = new DatabaseHelper(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.tripmap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.tripmap));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        display();

    }

    public void display()
    {
        Bundle extras = this.getIntent().getExtras();
        String date = extras.getString("date");
        String name = extras.getString("name");
        String address = extras.getString("address");
        String category = extras.getString("category");
        String lat = extras.getString("lat");
        String lng = extras.getString("lng");



        Cursor cursor = myDatabaseHelper.getMyTripDate(date);

        if (cursor.moveToFirst()){
            do{
                String tripname = cursor.getString(cursor.getColumnIndex("MYTRIPNAME"));
                String tripaddress = cursor.getString(cursor.getColumnIndex("MYTRIPADDRESS"));
                String tripcat = cursor.getString(cursor.getColumnIndex("MYTRIPCATEGORY"));
                String triplat = cursor.getString(cursor.getColumnIndex("MYTRIPLAT"));
                String triplng = cursor.getString(cursor.getColumnIndex("MYTRIPLNG"));

                double latitude = Double.parseDouble(triplat);
                double longitude = Double.parseDouble(triplng);

                final LatLngBounds.Builder mapBuilder = new LatLngBounds.Builder();
                final LatLng ll = new LatLng(latitude, longitude);
                MarkerOptions options = new MarkerOptions()
                        .position(ll)
                        .title(tripname)
                        .snippet(tripaddress)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                Marker marker = mMap.addMarker(options);
                mapBuilder.include(marker.getPosition());

                if(tripcat.equals("Morning"))
                {
                    mMap.addCircle(new CircleOptions()
                            .center(new LatLng(latitude, longitude))
                            .radius(500)
                            .strokeWidth(0)
                            .fillColor(Color.parseColor("#FF7F50")));

                }
                if(tripcat.equals("Afternoon"))
                {
                    mMap.addCircle(new CircleOptions()
                            .center(new LatLng(latitude, longitude))
                            .radius(500)
                            .strokeWidth(0)
                            .fillColor(Color.parseColor("#DA70D6")));
                }
                if(tripcat.equals("Evening"))
                {
                    mMap.addCircle(new CircleOptions()
                            .center(new LatLng(latitude, longitude))
                            .radius(500)
                            .strokeWidth(0)
                            .fillColor(Color.parseColor("#008080")));
                }

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 11));

            }while(cursor.moveToNext());
        }
        cursor.close();

    }

}

