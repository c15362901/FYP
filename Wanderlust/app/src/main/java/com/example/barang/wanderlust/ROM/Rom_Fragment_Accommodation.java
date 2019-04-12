package com.example.barang.wanderlust.ROM;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.barang.wanderlust.MainPage;
import com.example.barang.wanderlust.R;
import com.example.barang.wanderlust.RecyclerViewAdapter;

import java.util.ArrayList;

public class Rom_Fragment_Accommodation extends Fragment{

    public Rom_Fragment_Accommodation() {
        // Required empty public constructor
    }


    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ArrayList<String> bnbName = new ArrayList<>();
    private ArrayList<String> bnbUrl = new ArrayList<>();

    private ArrayList<String> hostelName = new ArrayList<>();
    private ArrayList<String> hostelUrl = new ArrayList<>();

    private ArrayList<String> motelName = new ArrayList<>();
    private ArrayList<String> motelUrl = new ArrayList<>();

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    Cursor c;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.accomm, container, false);

        getImages();
        getBnb();
        getHostel();
        getMotel();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);

        textView = (TextView) view.findViewById(R.id.hotel_see_all);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Hotel");
                intent.putExtra("city", "Rome");
                intent.putExtra("table", "rome");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(getContext(), bnbName, bnbUrl);
        recyclerView2.setAdapter(adapter2);

        textView2 = (TextView) view.findViewById(R.id.bnb_see_all);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Bed & Breakfast");
                intent.putExtra("city", "Rome");
                intent.putExtra("table", "rome");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView4 = view.findViewById(R.id.recyclerView4);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager4);
        RecyclerViewAdapter adapter4 = new RecyclerViewAdapter(getContext(), hostelName, hostelUrl);
        recyclerView4.setAdapter(adapter4);

        textView4 = (TextView) view.findViewById(R.id.hostel_see_all);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Hostel");
                intent.putExtra("city", "Rome");
                intent.putExtra("table", "rome");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView5 = view.findViewById(R.id.recyclerView5);
        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(layoutManager5);
        RecyclerViewAdapter adapter5 = new RecyclerViewAdapter(getContext(), motelName, motelUrl);
        recyclerView5.setAdapter(adapter5);

        textView5 = (TextView) view.findViewById(R.id.motel_see_all);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Motel");
                intent.putExtra("city", "Rome");
                intent.putExtra("table", "rome");
                startActivity(intent);
            }
        });
        return view;
    }

    private void getImages() {
        mImageUrls.add("https://i.ibb.co/cTk5mMX/piccolo.jpg");
        mNames.add("Hotel il Piccolo Borgo");

        mImageUrls.add("https://i.ibb.co/VVWfZyt/continentale.jpg");
        mNames.add("Hotel Continentale");

        mImageUrls.add("https://i.ibb.co/sRbJhQt/claridge.jpg");
        mNames.add("Hotel Claridge");

        mImageUrls.add("https://i.ibb.co/xS7f1VL/milano.jpg");
        mNames.add("Milano Hotel Rome");
    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/VxNTpVw/lory.jpeg");
        bnbName.add("Casa Lory");

        bnbUrl.add("https://i.ibb.co/pvJzPdj/domus.jpg");
        bnbName.add("B&B Domus");

        bnbUrl.add("https://i.ibb.co/zS0dydt/arches.jpg");
        bnbName.add("Arches B&b");
    }
    private void getHostel() {
        hostelUrl.add("https://i.ibb.co/m5k9N3B/zen.jpg");
        hostelName.add("Zen House");

        hostelUrl.add("https://i.ibb.co/kqk3P5M/dreaming.jpg");
        hostelName.add("Dreaming Rome Hostel");

        hostelUrl.add("https://i.ibb.co/DtwFzb0/sunshine.jpg");
        hostelName.add("Sunshine Hostel");

        hostelUrl.add("https://i.ibb.co/JBLDG7T/peterpan.jpg");
        hostelName.add("Peter Pan Hostel");
    }


    private void getMotel() {
        motelUrl.add("https://i.ibb.co/3WWLkxW/belvedere.jpg");
        motelName.add("Belvedere");


    }

}

