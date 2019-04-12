package com.example.barang.wanderlust.AMS;

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

public class Ams_Fragment_Accommodation extends Fragment{

    public Ams_Fragment_Accommodation() {
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
                intent.putExtra("city", "Amsterdam");
                intent.putExtra("table", "amsterdam");
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
                intent.putExtra("city", "Amsterdam");
                intent.putExtra("table", "amsterdam");
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
                intent.putExtra("city", "Amsterdam");
                intent.putExtra("table", "amsterdam");
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
                intent.putExtra("city", "Amsterdam");
                intent.putExtra("table", "amsterdam");
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
                intent.putExtra("city", "Amsterdam");
                intent.putExtra("table", "amsterdam");
                startActivity(intent);
            }
        });
        return view;
    }


    private void getImages() {
        mImageUrls.add("https://i.ibb.co/tQFsrsV/hem.jpeg");
        mNames.add("HEM Hotel");

        mImageUrls.add("https://i.ibb.co/rc4BZTJ/tulip.jpg");
        mNames.add("Tulip Inn");

        mImageUrls.add("https://i.ibb.co/zrjXbXn/rho.jpg");
        mNames.add("RHO Hotel");

        mImageUrls.add("https://i.ibb.co/tJ0G28n/mate.jpg");
        mNames.add("Mate Hotel");

        mImageUrls.add("https://i.ibb.co/GWtjHG7/hotelcc.jpg");
        mNames.add("Hotel CC");
    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/LJR0cdd/bnb.jpg");
        bnbName.add("BnB Amsterdam");

        bnbUrl.add("https://i.ibb.co/hVVffp0/dreamon.jpg");
        bnbName.add("Dream On");

        bnbUrl.add("https://i.ibb.co/KXp35m1/whitezen.jpg");
        bnbName.add("White Zen");

        bnbUrl.add("https://i.ibb.co/JRbdfV4/servio.jpg");
        bnbName.add("BB by Servio");
    }

    private void getResort() {
        resortUrl.add("https://i.ibb.co/kccTc91/huize.jpeg");
        resortName.add("Huize Verel");

        resortUrl.add("https://i.ibb.co/PNQQpC1/hawaijburg.jpg");
        resortName.add("Hawaijburg");

        resortUrl.add("https://i.ibb.co/pyd5S0M/groene.jpg");
        resortName.add("Groene Trappenhuis");


    }

    private void getHostel() {
        hostelUrl.add("https://i.ibb.co/q9NHShL9/hotelben.jpg");
        hostelName.add("Hotel Ben");

        hostelUrl.add("https://i.ibb.co/26RrqyT/hortus.jpg");
        hostelName.add("Pension Hortus");
    }


    private void getMotel() {
        motelUrl.add("https://ibb.co/58nBqRk/luvboat.jpg");
        motelName.add("The Luv Boat");

    }


}

