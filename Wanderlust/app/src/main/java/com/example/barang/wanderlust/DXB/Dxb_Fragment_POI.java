package com.example.barang.wanderlust.DXB;

import android.content.Intent;
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

public class Dxb_Fragment_POI extends Fragment {

    public Dxb_Fragment_POI() {
        // Required empty public constructor
    }

    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ArrayList<String> monumentName = new ArrayList<>();
    private ArrayList<String> monumentUrl = new ArrayList<>();

    private ArrayList<String> uniName = new ArrayList<>();
    private ArrayList<String> uniUrl = new ArrayList<>();

    private ArrayList<String> convName = new ArrayList<>();
    private ArrayList<String> convUrl = new ArrayList<>();

    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    Intent intent;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.poi, container, false);

        getImages();
        getConv();
        getMonument();


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);

        textView = (TextView) view.findViewById(R.id.library_see_all);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Library");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });


        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView3);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(getContext(), monumentName, monumentUrl);
        recyclerView3.setAdapter(adapter3);

        textView3 = (TextView) view.findViewById(R.id.monument_see_all);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Monument");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });


        RecyclerView recyclerView5 = view.findViewById(R.id.recyclerView5);
        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(layoutManager5);
        RecyclerViewAdapter adapter5 = new RecyclerViewAdapter(getContext(), convName, convUrl);
        recyclerView5.setAdapter(adapter5);

        textView5 = (TextView) view.findViewById(R.id.convention_see_all);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Convention Centre");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });
        return view;

    }

    private void getImages()
    {
        mImageUrls.add("https://i.ibb.co/5YW59q5/old.jpg");
        mNames.add("The Old Library");

        mImageUrls.add("https://i.ibb.co/25fbv0P/public.jpg");
        mNames.add("Public Library");
    }


    private void getMonument()
    {
        monumentUrl.add("https://i.ibb.co/R6JVvPVP/hatta.jpg");
        monumentName.add("Hatta Village");

        monumentUrl.add("https://i.ibb.co/6JVvPVP/majlis.jpg");
        monumentName.add("Al Sheif Majlis");

        monumentUrl.add("https://i.ibb.co/Bgks3zd/Bastakiya.jpg");
        monumentName.add("Al Bastakiya");
    }

    private void getConv()
    {
        convUrl.add("https://i.ibb.co/3CP2zbF/wtc.jpeg");
        convName.add("Dubai WTC");

        convUrl.add("https://i.ibb.co/x69S0wp/knowledge.jpg");
        convName.add("Knowledge Village");

        convUrl.add("https://i.ibb.co/WWzwHsR/godolphin.jpg");
        convName.add("Godolphin Ballroom");

    }

}
