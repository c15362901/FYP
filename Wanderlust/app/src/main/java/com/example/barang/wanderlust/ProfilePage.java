package com.example.barang.wanderlust;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class ProfilePage extends Fragment {

    public static ProfilePage newInstance(){
        ProfilePage profilepage = new ProfilePage();
        return profilepage;
    }

    DatabaseHelper myDb;
    ListView itemList;
    TextView tvFname;
    TextView tvLname;
    TextView tvEmail;
    TextView tvPhone;
    TextView tvUsername;
    Intent intent;
    Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        myDb = new DatabaseHelper(getContext());
        tvFname = (TextView) view.findViewById(R.id.tvFname);
        tvLname = (TextView) view.findViewById(R.id.tvLname);
        tvEmail = (TextView) view.findViewById(R.id.tvEmail);
        tvPhone = (TextView) view.findViewById(R.id.tvPhone);
        tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        itemList = (ListView) view.findViewById(R.id.upcoming_lv);
        btn = (Button) view.findViewById(R.id.logoutbtn);


        checkTrips();
        displayTrips();
        logout();

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        SharedPreferences pref = getContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
        final String currentUser = pref.getString("username","");

        String fName = myDb.getName(currentUser);
        String lName = myDb.getLName(currentUser);
        String email = myDb.getEmail(currentUser);
        String phone = myDb.getPhone(currentUser);
        String username = myDb.getUser(currentUser);

        tvFname.setText(fName);
        tvLname.setText(lName);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvUsername.setText(username);

    }

    public void displayTrips()
    {
        Cursor cur = myDb.getMyTrips();
        String[] from = new String[]{DatabaseHelper.MY_TRIPTITLE, DatabaseHelper.MY_TRIPDATE};
        int[] to = new int[]{R.id.textView, R.id.textView5};
        SimpleCursorAdapter reviewAdapter;
        reviewAdapter = new SimpleCursorAdapter(getContext(), R.layout.profile_trips_layout, cur, from, to,0);
        reviewAdapter.notifyDataSetChanged();
        itemList.setAdapter(reviewAdapter);
        itemList.setTextFilterEnabled(true);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView mydate = (TextView)view.findViewById(R.id.textView5);
                String itemDate = mydate.getText().toString();
                intent = new Intent(getActivity(), TripMap.class);
                intent.putExtra("date", itemDate);
                startActivity(intent);
            }
        });

    }

    public void logout()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getContext().getSharedPreferences("Login", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.remove("username");
                editor.remove("address");
                editor.remove("email");
                editor.remove("phone");
                editor.remove("lastname");
                editor.remove("firstname");

                editor.commit();
                startActivity(new Intent(getActivity(),MainActivity.class));
                getActivity().finish();
            }
        });
    }

    public void checkTrips()
    {


    }

}
