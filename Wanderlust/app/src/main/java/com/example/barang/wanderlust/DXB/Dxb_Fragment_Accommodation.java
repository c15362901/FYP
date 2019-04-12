package com.example.barang.wanderlust.DXB;

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

public class Dxb_Fragment_Accommodation extends Fragment{

    public Dxb_Fragment_Accommodation() {
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
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
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
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
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
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
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
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });
        return view;

    }

    private void getImages() {
        mImageUrls.add("https://i.ibb.co/k83TH3q/metropolitan.jpg");
        mNames.add("Metropolitan Hotel");

        mImageUrls.add("https://i.ibb.co/vJjyYmWy/jumeirah.jpg");
        mNames.add("Jumeirah Beach Hotel");

        mImageUrls.add("https://i.ibb.co/HTkJtdF/hyatt.jpg");
        mNames.add("Grand Hyatt Hotel");

        mImageUrls.add("https://i.ibb.co/YZ1s1Rr/shangrila.jpg");
        mNames.add("Shangri-La Hotel");

    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/D8FTMyV/goldentulip.jpg");
        bnbName.add("Golden Tulip");

        bnbUrl.add("https://i.ibb.co/jkXXYsP/mirabella.jpeg");
        bnbName.add("Mirabella Villa");

        bnbUrl.add("https://i.ibb.co/w4T49fW/bavaria.jpg");
        bnbName.add("Bavaria Executive Suites");
    }

    private void getResort() {
        resortUrl.add("https://i.ibb.co/w4T49fW/amara.jpg");
        resortName.add("Amara Spa");

        resortUrl.add("https://i.ibb.co/8Nz0sPc/dreamland.jpg");
        resortName.add("Dreamland");

        resortUrl.add("https://i.ibb.co/bsYjPbn/sharjian.jpg");
        resortName.add("Beach Hotel Sharjian");

        resortUrl.add("https://i.ibb.co/ZcK951K/palace.jpg");
        resortName.add("The Palace Downtown");
    }

    private void getHostel() {
        hostelUrl.add("https://i.ibb.co/YN9q4zm/medical.jpg");
        hostelName.add("Dubai Medical College Hostel");
    }
}

