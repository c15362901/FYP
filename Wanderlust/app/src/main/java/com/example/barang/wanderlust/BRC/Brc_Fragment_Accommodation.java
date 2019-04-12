package com.example.barang.wanderlust.BRC;

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

public class Brc_Fragment_Accommodation extends Fragment{

    public Brc_Fragment_Accommodation() {
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
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
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
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
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
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView4 = view.findViewById(R.id.recyclerView4);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager4);
        RecyclerViewAdapter adapter4 = new RecyclerViewAdapter(getContext(),hostelName, hostelUrl);
        recyclerView4.setAdapter(adapter4);

        textView4 = (TextView) view.findViewById(R.id.hostel_see_all);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Hostel");
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
                startActivity(intent);
            }
        });

        return view;

    }

    private void getImages() {
        mImageUrls.add("https://i.ibb.co/KhjFDGc/mandarin.jpg");
        mNames.add("Mandarin Oriental");

        mImageUrls.add("https://i.ibb.co/PMGcNB1/autohogar.jpg");
        mNames.add("Autohogar");

        mImageUrls.add("https://i.ibb.co/1qvRTf5/isabela.jpg");
        mNames.add("Hotel La Isabela");

        mImageUrls.add("https://i.ibb.co/1rkPrqx/hcc.jpg");
        mNames.add("HCC Lugano");
    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/JqxFmmc/casareal.jpeg");
        bnbName.add("Casa Real");

        bnbUrl.add("https://i.ibb.co/N1g78ZZ/aparthotel.jpg");
        bnbName.add("Aparthotel Silver");

        bnbUrl.add("https://i.ibb.co/27x8Drw/sata.png");
        bnbName.add("SATA Apartamentos");

        bnbUrl.add("https://i.ibb.co/BTgj9St/vaixell.jpg");
        bnbName.add("El Vaixell de Paper");
    }

    private void getResort() {
        resortUrl.add("https://i.ibb.co/yqggkkR/ballesol.jpg");
        resortName.add("Ballesol");
    }

    private void getHostel() {
        hostelUrl.add("https://i.ibb.co/Njq100R/paraiso.jpg");
        hostelName.add("Paraiso Travellers");

        hostelUrl.add("https://i.ibb.co/D4RmFMX/centralgarden.jpg");
        hostelName.add("Central Garden");

        hostelUrl.add("https://i.ibb.co/zn2Q9Fb/eixample.jpg");
        hostelName.add("BCN Eixample");

        hostelUrl.add("https://i.ibb.co/XWxJrNq/wow.jpg");
        hostelName.add("WOW! Hostel");
    }
}
