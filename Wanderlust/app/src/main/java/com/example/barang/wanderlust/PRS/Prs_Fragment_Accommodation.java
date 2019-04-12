package com.example.barang.wanderlust.PRS;

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

public class Prs_Fragment_Accommodation extends Fragment{

    public Prs_Fragment_Accommodation() {
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
                intent.putExtra("city", "Paris");
                intent.putExtra("table", "paris");
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
                intent.putExtra("city", "Paris");
                intent.putExtra("table", "paris");
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
                intent.putExtra("city", "Paris");
                intent.putExtra("table", "paris");
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
                intent.putExtra("city", "Paris");
                intent.putExtra("table", "paris");
                startActivity(intent);
            }
        });
        return view;

    }

    private void getImages() {
        mImageUrls.add("https://i.ibb.co/2PMRd8W/minerve.jpg");
        mNames.add("Hotel Minerve");

        mImageUrls.add("https://i.ibb.co/tQFqmQ9/napoleon.jpg");
        mNames.add("Hotel Napoleon");

        mImageUrls.add("https://i.ibb.co/QNZm4Zj/murano.jpg");
        mNames.add("Murano Urban");

        mImageUrls.add("https://i.ibb.co/BcgfWSV/leurope.jpg");
        mNames.add("Hotel de L'Europe");

        mImageUrls.add("https://i.ibb.co/1XjXPgb/belfort.jpg");
        mNames.add("Hotel De Belfort");

    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/fGNxGYC/fabric.jpg");
        bnbName.add("Fabric");
    }

    private void getResort() {
        resortUrl.add("https://i.ibb.co/gzV5pQ9/entree.jpg");
        resortName.add("L'Entree Des Artistes");
    }

    private void getHostel() {
        hostelUrl.add("https://i.ibb.co/F8rbK9d/oops.jpg");
        hostelName.add("Oops! Hostel");
    }

}

