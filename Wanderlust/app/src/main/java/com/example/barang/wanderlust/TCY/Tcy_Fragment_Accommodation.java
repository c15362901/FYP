package com.example.barang.wanderlust.TCY;

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

public class Tcy_Fragment_Accommodation extends Fragment{

    public Tcy_Fragment_Accommodation() {
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
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
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
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
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
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
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
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
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
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
                startActivity(intent);
            }
        });
        return view;

    }


    private void getImages() {
        mImageUrls.add("https://i.ibb.co/Y7WgSQj/arenella.jpg");
        mNames.add("Hotel Arenella");

        mImageUrls.add("https://i.ibb.co/TmP8w60/rita.jpg");
        mNames.add("Hotel Villa Rita");

        mImageUrls.add("https://i.ibb.co/kKzMV5K/sardi.jpg");
        mNames.add("Hotel Sardi");

        mImageUrls.add("https://i.ibb.co/8DnBhZY/anna.jpg");
        mNames.add("Hotel Anna");

    }

    private void getBnb() {
        bnbUrl.add("https://i.ibb.co/dLhsr39/limoni.jpg");
        bnbName.add("Villa dei Limoni");

        bnbUrl.add("https://i.ibb.co/WKCJ7Pw/collina.jpg");
        bnbName.add("La collina");

        bnbUrl.add("https://i.ibb.co/ByxH4V5/cepanne.jpg");
        bnbName.add("Le Cepanne");
    }

    private void getResort() {
        resortUrl.add("https://i.ibb.co/P1KPbfk/aviotel.jpg");
        resortName.add("Aviotel");

        resortUrl.add("https://i.ibb.co/ZJM6Ppn/sirena.jpg");
        resortName.add("Sirena Beach Club");

        resortUrl.add("https://i.ibb.co/hYfNVNw/greenpark.jpg");
        resortName.add("Green Park Resort");

        resortUrl.add("https://i.ibb.co/yyB03w6/lemurelle.jpg");
        resortName.add("Le Murelle");
    }

    private void getHostel() {

        hostelUrl.add("https://i.ibb.co/71vThYv/ostello.jpg");
        hostelName.add("Ostello Apuano");

        hostelUrl.add("https://i.ibb.co/Ld0p63S/hostelpisa.jpg");
        hostelName.add("Hostel Pisa");

        hostelUrl.add("https://i.ibb.co/7KVkWqN/duilio.jpg");
        hostelName.add("Duilio Hostel");
    }


    private void getMotel() {
        motelUrl.add("https://i.ibb.co/kJfq9VS/motelparco.jpg");
        motelName.add("Motel Parco delle Rose");

        motelUrl.add("https://i.ibb.co/nf4WfNS/astor.jpg");
        motelName.add("Astor");

    }
}

