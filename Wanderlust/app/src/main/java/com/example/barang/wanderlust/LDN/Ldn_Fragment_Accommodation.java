package com.example.barang.wanderlust.LDN;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barang.wanderlust.MainPage;
import com.example.barang.wanderlust.R;
import com.example.barang.wanderlust.RecyclerViewAdapter;

import java.io.IOException;
import java.util.ArrayList;

public class Ldn_Fragment_Accommodation extends Fragment {

    public Ldn_Fragment_Accommodation() {
        // Required empty public constructor
    }

    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ArrayList<String> bnbName = new ArrayList<>();
    private ArrayList<String> bnbUrl = new ArrayList<>();

    private ArrayList<String> resortName = new ArrayList<>();
    private ArrayList<String> resortUrl = new ArrayList<>();

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
        getResort();
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
                intent.putExtra("city", "London");
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
                intent.putExtra("city", "London");
                intent.putExtra("table", "london");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView3);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(getContext(), resortName, resortUrl);
        recyclerView3.setAdapter(adapter3);

        textView3 = (TextView) view.findViewById(R.id.resort_see_all);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Resort");
                intent.putExtra("city", "London");
                intent.putExtra("table", "london");
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
                intent.putExtra("city", "London");
                intent.putExtra("table", "london");
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
                intent.putExtra("city", "London");
                intent.putExtra("table", "london");
                startActivity(intent);
            }
        });

        return view;


    }

    private void getImages() {
        mImageUrls.add("https://i.ibb.co/26zFn7S/corinthia.jpg");
        mNames.add("Corinthia Hotel");

        mImageUrls.add("https://i.ibb.co/s2PFvky/ritz.jpg");
        mNames.add("The Ritz");

        mImageUrls.add("https://i.ibb.co/pvv3vnz/dorchester.jpg");
        mNames.add("Dorchester Hotel");

        mImageUrls.add("https://i.ibb.co/fNrGNvC/savoy.jpg");
        mNames.add("Savoy Hotel");

        mImageUrls.add("https://i.ibb.co/cQH1HMB/shangrila.jpg");
        mNames.add("Shangri-La Hotel");

        mImageUrls.add("https://i.ibb.co/kgJdBXm/bulgari.jpg");
        mNames.add("Bvlgari Hotel");
    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/RTGVbFk/barclay.jpg");
        bnbName.add("Barclay B&B");

        bnbUrl.add("https://i.ibb.co/qD1shBx/charlotte.jpg");
        bnbName.add("Charlotte");

        bnbUrl.add("https://i.ibb.co/Hr0VKjP/palmers.jpg");
        bnbName.add("Palmers Lodge");

        bnbUrl.add("https://i.ibb.co/q5vy0Tq/georgian.jpg");
        bnbName.add("Georgian House");

        bnbUrl.add("https://i.ibb.co/NrWBBH6/venture.jpg");
        bnbName.add("Venture House");
    }

    private void getResort() {
        resortUrl.add("https://i.ibb.co/2ZFwmjT/park-plaza.jpg");
        resortName.add("Park Plaza");

        resortUrl.add("https://i.ibb.co/ZSW0Fzr/intercontinental.jpg");
        resortName.add("Intercontinental");

        resortUrl.add("https://i.ibb.co/hYhGz0y/novotel.jpg");
        resortName.add("Novotel Excel");

        resortUrl.add("https://i.ibb.co/QNjyGp5/sunborn.jpg");
        resortName.add("Sunborn London");

        resortUrl.add("https://i.ibb.co/3hjnYzC/blackfriars.jpg");
        resortName.add("Novotel Blackfriars");
    }

    private void getHostel() {
        hostelUrl.add("https://i.ibb.co/VmjMPG9/palmerslodge.jpg");
        hostelName.add("Palmers Lodge");

        hostelUrl.add("https://i.ibb.co/2MJfP3L/yha.jpg");
        hostelName.add("YHA Central");

        hostelUrl.add("https://i.ibb.co/GnyVJ5f/wombats.jpg");
        hostelName.add("Wombat's Hostel");

        hostelUrl.add("https://i.ibb.co/0VSkDSG/safestay.jpg");
        hostelName.add("Safestay");

        hostelUrl.add("https://i.ibb.co/fxkCJwx/walrus.jpg");
        hostelName.add("Walrus Hostel");
    }


    private void getMotel() {
        motelUrl.add("https://i.ibb.co/4fvNZF8/travelodge.jpg");
        motelName.add("Travelodge");

        motelUrl.add("https://i.ibb.co/Lttn4KJ/roomy.jpg");
        motelName.add("Roomy");

    }
}


