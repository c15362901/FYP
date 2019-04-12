package com.example.barang.wanderlust;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barang.wanderlust.AMS.Ams_HomePage;
import com.google.android.gms.maps.CameraUpdate;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class Map extends Fragment implements OnMapReadyCallback {

    public static Map newInstance() {
        Map mappage = new Map();


        return mappage;
    }

    private DrawerLayout drawer;
    private Toolbar toolBar;
    private ActionBarDrawerToggle toggle;


    private GoogleMap mMap;
    private BottomSheetBehavior bottomSheetBehavior;
    private static boolean firstRun = false;

    private TextView tv_name;
    private TextView tv_address;
    Button add_btn;
    private int mYear, mMonth, mDay;
    private TextView tv_date;
    DatabaseHelper myDb;
    private DatabaseReference db;
    private Query db_filter;
    private ListView itemList;
    private ListView itemList2;
    private ListView itemList3;

    private TextView tvLat;
    private TextView tvLng;

    Button save_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.navigation_drawer, null, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        myDb = new DatabaseHelper(getContext());
        bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.bottomSheetLayout));
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        tv_name = (TextView) view.findViewById(R.id.welcome);
        tv_address = (TextView) view.findViewById(R.id.textView4);

        tvLat = (TextView) view.findViewById(R.id.textView3);
        tvLng = (TextView) view.findViewById(R.id.textView7);

        itemList = (ListView)view.findViewById(R.id.morning_lv);
        itemList2 = (ListView)view.findViewById(R.id.afternoon_lv);
        itemList3 = (ListView)view.findViewById(R.id.evening_lv);
        add_btn = (Button) view.findViewById(R.id.button);

        toolBar = (Toolbar) view.findViewById(R.id.toolbar_main);
        drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolBar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(null);

        NavigationView navigationView = (NavigationView)view.findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        tv_date = (TextView) headerView.findViewById(R.id.nav_header_textView);
        save_btn = (Button)view.findViewById(R.id.button2);

        toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        return view;
    }


    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = mMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            getContext(), R.raw.map));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        change();
        if (firstRun) {
            getLocation();

        } else {
            LatLng london = new LatLng(51.51, -0.129);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(london, 2));
            firstRun = true;
        }

    }

    void change()
    {
        FloatingActionButton itinerary = (FloatingActionButton) getView().findViewById(R.id.itinerary);
        itinerary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainPage.class);
                String itineraryID = "itinerary";
                intent.putExtra("itinerary", itineraryID);
                startActivity(intent);
            }
        });

        FloatingActionButton locations = (FloatingActionButton) getView().findViewById(R.id.countries);
        locations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Home();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.commit();
            }
        });

    }

    void getLocation()
    {
        Bundle extras = getActivity().getIntent().getExtras();
        String category = extras.getString("category");
        String city = extras.getString("city");
        String table = extras.getString("table");

        final ListView list = getView().findViewById(R.id.list);
        final SearchView search = getView().findViewById(R.id.searchview);
        search.setActivated(true);
        search.onActionViewExpanded();
        search.setIconified(false);

        final ArrayList<String> arrayList = new ArrayList<>();
        db = FirebaseDatabase.getInstance().getReference(city);
        db_filter = db.orderByChild("Sub").equalTo(category);
        db_filter.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snap: dataSnapshot.getChildren())
                {

                    final LatLngBounds.Builder mapBuilder = new LatLngBounds.Builder();
                    final double lat = snap.child("lat").getValue(Double.class);
                    final double lng = snap.child("lng").getValue(Double.class);
                    int polarity = snap.child("polarity").getValue(Integer.class);
                    final String name = snap.child("name").getValue(String.class);
                    final String address = snap.child("address").getValue(String.class);
                    double vader = snap.child("vader").getValue(Double.class);

                    if (vader < 0) {
                        vader = -vader;
                    }
                    else if(vader == 0)
                    {
                        vader = 1;
                    }
                    else
                    {
                        vader = vader+1;
                    }

                    arrayList.add(name);

                    final LatLng ll = new LatLng(lat, lng);
                    MarkerOptions options = new MarkerOptions()
                            .position(ll)
                            .anchor(0.5F, 1.0F)
                            .title(name)
                            .snippet(address)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                    Marker marker = mMap.addMarker(options);
                    mapBuilder.include(marker.getPosition());

                    mMap.addCircle(new CircleOptions()
                            .center(new LatLng(lat, lng))
                            .radius(vader * 400)
                            .strokeWidth(0)
                            .fillColor(Color.parseColor("#da70d6")));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ll, 12));

                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);
                    list.setAdapter(arrayAdapter);
                    search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                        @Override
                        public boolean onQueryTextSubmit(String query) {
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String newText) {
                            arrayAdapter.getFilter().filter(newText);
                            return false;
                        }
                    });

                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            final String clickedItem = (String) list.getItemAtPosition(position);
                            search(clickedItem);
                        }

                    });


                    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {

                            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                            String name = (String)marker.getTitle();
                            tv_name.setText(name);

                            String address = (String)marker.getSnippet();
                            tv_address.setText(address);


                            // convert double to string when inserting in TextView

                            Double lat = (Double)marker.getPosition().latitude;
                            Double lng = (Double)marker.getPosition().longitude;

                            String latitude = Double.toString(lat);
                            String longitude = Double.toString(lng);

                            tvLat.setText(latitude);
                            tvLng.setText(longitude);

                            createItinerary();
                            return false;
                        }

                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });
    }

    private void search(String item)
    {
        Bundle extras = getActivity().getIntent().getExtras();
        String category = extras.getString("category");
        String city = extras.getString("city");
        String table = extras.getString("table");

        db = FirebaseDatabase.getInstance().getReference(city);
        db_filter = db.orderByChild("name").equalTo(item);
        db_filter.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snap: dataSnapshot.getChildren())
                {
                    final double lat = snap.child("lat").getValue(Double.class);
                    final double lng = snap.child("lng").getValue(Double.class);

                    final LatLng ll = new LatLng(lat, lng);

                    CameraUpdate location = CameraUpdateFactory.newLatLngZoom(
                            ll, 14);
                    mMap.animateCamera(location);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });

    }


    void createItinerary()
    {
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                AlertDialog dialog = builder.create();
                dialog.setButton(Dialog.BUTTON_POSITIVE, "Existing Itinerary", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(myDb.checkTrip()) {
                            Toast.makeText(getContext(), "Please create an itinerary.", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                          showExistingDates();
                        }
                    }
                });
                dialog.setButton(Dialog.BUTTON_NEUTRAL, "Create Itinerary", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final Calendar c = Calendar.getInstance();
                        mYear = c.get(Calendar.YEAR);
                        mMonth = c.get(Calendar.MONTH);
                        mDay = c.get(Calendar.DAY_OF_MONTH);


                        DatePickerDialog dpd = new DatePickerDialog(getContext(),
                                new DatePickerDialog.OnDateSetListener() {

                                    @Override
                                    public void onDateSet(DatePicker view, int year,
                                                          int monthOfYear, int dayOfMonth) {

                                        final String date = tv_date.getText().toString();
                                        tv_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                        if(!myDb.checkDate(date)) {
                                            showDialog(date);
                                        }
                                        else
                                        {
                                            showExistingDates();
                                        }

                                        save(date);


                                    }
                                }, mYear, mMonth, mDay);
                        dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                        dpd.show();

                    }

                });
                dialog.show();
            }
        });
    }

    public void showDialog(final String date)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        AlertDialog dialog = builder.create();
        dialog.setButton(Dialog.BUTTON_POSITIVE, "Evening", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = tv_name.getText().toString();
                String address = tv_address.getText().toString();
                String lat = tvLat.getText().toString();
                String lng = tvLng.getText().toString();

                String category = "Evening";
                if (myDb.isItem(name, date, category)) {
                    Toast.makeText(getContext(), "Already in your itinerary!", Toast.LENGTH_LONG).show();
                } else {
                    myDb.addItinerary(name, address, category, date, lat, lng);
                    Toast.makeText(getContext(), "Item added", Toast.LENGTH_LONG).show();
                    displayMorning(date);
                    displayAfternoon(date);
                    displayEvening(date);

                }

            }
        });
        dialog.setButton(Dialog.BUTTON_NEGATIVE, "Afternoon", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = tv_name.getText().toString();
                String address = tv_address.getText().toString();
                String lat = tvLat.getText().toString();
                String lng = tvLng.getText().toString();
                String category = "Afternoon";
                if (myDb.isItem(name, date, category)) {
                    Toast.makeText(getContext(), "Already in your itinerary!", Toast.LENGTH_LONG).show();
                } else {
                    myDb.addItinerary(name, address, category, date, lat, lng);
                    Toast.makeText(getContext(), "Item added", Toast.LENGTH_LONG).show();
                    displayMorning(date);
                    displayAfternoon(date);
                    displayEvening(date);
                }

            }
        });
        dialog.setButton(Dialog.BUTTON_NEUTRAL, "Morning", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = tv_name.getText().toString();
                String address = tv_address.getText().toString();
                String category = "Morning";
                String lat = tvLat.getText().toString();
                String lng = tvLng.getText().toString();

                if (myDb.isItem(name, date, category)) {
                    Toast.makeText(getContext(), "Already in your itinerary!", Toast.LENGTH_LONG).show();
                }
                else{
                    myDb.addItinerary(name, address, category, date, lat, lng);
                    Toast.makeText(getContext(), "Item added", Toast.LENGTH_LONG).show();
                    displayMorning(date);
                    displayAfternoon(date);
                    displayEvening(date);



                }

            }
        });
        dialog.show();

    }

    public void showExistingDates()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final String[] cs = myDb.getAllStringValues().toArray(new String[myDb.getAllStringValues().size()]);
        builder.setTitle("Dates");
        builder.setItems(cs, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                showDialog(cs[id]);
                tv_date.setText(cs[id]);
                save(cs[id]);
            }
        });
        builder.show();


    }

    private void displayMorning(final String tripdate)
    {
        Cursor cur = myDb.getMorningItinerary(tripdate);
        String[] from = new String[]{DatabaseHelper.COL_TRIPNAME, DatabaseHelper.COL_TRIPADDRESS, DatabaseHelper.COL_TRIPCATEGORY};
        int[] to = new int[]{R.id.tName};
        SimpleCursorAdapter reviewAdapter;
        reviewAdapter = new SimpleCursorAdapter(getContext(), R.layout.item_layout, cur, from, to,0);
        itemList.setAdapter(reviewAdapter);
        itemList.setTextFilterEnabled(true);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView name = (TextView)getView().findViewById(R.id.tName);
                String itemName = name.getText().toString();
                deleteItem(itemName);
                displayMorning(tripdate);
            }
        });
    }

    private void displayAfternoon(final String tripdate)
    {
        Cursor cur = myDb.getAfternoonItinerary(tripdate);
        String[] from = new String[]{DatabaseHelper.COL_TRIPNAME, DatabaseHelper.COL_TRIPADDRESS, DatabaseHelper.COL_TRIPCATEGORY};
        int[] to = new int[]{R.id.tName};
        SimpleCursorAdapter reviewAdapter;
        reviewAdapter = new SimpleCursorAdapter(getContext(), R.layout.item_layout, cur, from, to,0);
        itemList2.setAdapter(reviewAdapter);
        itemList2.setTextFilterEnabled(true);
        itemList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView name = (TextView)getView().findViewById(R.id.tName);
                String itemName = name.getText().toString();
                deleteItem(itemName);
                displayAfternoon(tripdate);
            }
        });
    }

    private void displayEvening(final String tripdate)
    {
        Cursor cur = myDb.getEveningItinerary(tripdate);
        String[] from = new String[]{DatabaseHelper.COL_TRIPNAME, DatabaseHelper.COL_TRIPADDRESS, DatabaseHelper.COL_TRIPCATEGORY};
        int[] to = new int[]{R.id.tName};
        SimpleCursorAdapter reviewAdapter;
        reviewAdapter = new SimpleCursorAdapter(getContext(), R.layout.item_layout, cur, from, to,0);
        itemList3.setAdapter(reviewAdapter);
        itemList3.setTextFilterEnabled(true);
        itemList3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView name = (TextView)getView().findViewById(R.id.tName);
                String itemName = name.getText().toString();
                deleteItem(itemName);
                displayEvening(tripdate);
            }
        });
    }



    private void deleteItem(final String itemName){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Remove Item?");
        builder.setMessage("Are you sure you want to remove this item?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //delete menu item
                myDb.deleteItemFromItinerary(itemName);
                Toast.makeText(getContext(), "Item Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void save(final String date)
    {
       save_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
               builder.setTitle("Enter Itinerary Name:");
               final EditText edittext = new EditText(getContext());
               builder.setView(edittext);


               builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int which) {

                       final String title = edittext.getText().toString();
                       Cursor cursor = myDb.getTrip(date);

                       if (cursor.moveToFirst()){
                           do{
                               String date = cursor.getString(cursor.getColumnIndex("TRIPDATE"));
                               String tripname = cursor.getString(cursor.getColumnIndex("TRIPNAME"));
                               String tripaddress = cursor.getString(cursor.getColumnIndex("TRIPADDRESS"));
                               String tripcat = cursor.getString(cursor.getColumnIndex("TRIPCATEGORY"));
                               String triplat = cursor.getString(cursor.getColumnIndex("TRIPLAT"));
                               String triplng = cursor.getString(cursor.getColumnIndex("TRIPLNG"));

                               myDb.addToTrip(title,date,tripname,tripaddress,tripcat,triplat,triplng);

                           }while(cursor.moveToNext());
                       }
                       cursor.close();

                       Toast.makeText(getContext(), "Saved!", Toast.LENGTH_SHORT).show();
                   }
               });

               builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();

                   }
               });

               AlertDialog alert = builder.create();
               alert.show();
           }
       });
    }



}


