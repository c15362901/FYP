package com.example.barang.wanderlust.TCY;

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

public class Tcy_Fragment_Restaurant extends Fragment {
    public Tcy_Fragment_Restaurant() {
        // Required empty public constructor
    }

    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ArrayList<String> resName = new ArrayList<>();
    private ArrayList<String> resUrl = new ArrayList<>();

    private ArrayList<String> bakeryName = new ArrayList<>();
    private ArrayList<String> bakeryUrl = new ArrayList<>();

    private ArrayList<String> dessertName = new ArrayList<>();
    private ArrayList<String> dessertUrl = new ArrayList<>();

    private ArrayList<String> cafeName = new ArrayList<>();
    private ArrayList<String> cafeUrl = new ArrayList<>();


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

        View view = inflater.inflate(R.layout.restaurant, container, false);

        getImages();
        getRes();
        getBakery();
        getCafe();
        getDessert();


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);

        textView = (TextView) view.findViewById(R.id.fastfood_see_all);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Fast Food");
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(getContext(), resName, resUrl);
        recyclerView2.setAdapter(adapter2);

        textView2 = (TextView) view.findViewById(R.id.restaurant_see_all);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Restaurant");
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView3);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(getContext(),  bakeryName,bakeryUrl);
        recyclerView3.setAdapter(adapter3);

        textView3 = (TextView) view.findViewById(R.id.bakery_see_all);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Bakery");
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView4 = view.findViewById(R.id.recyclerView4);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager4);
        RecyclerViewAdapter adapter4 = new RecyclerViewAdapter(getContext(), dessertName,dessertUrl);
        recyclerView4.setAdapter(adapter4);

        textView4 = (TextView) view.findViewById(R.id.dessert_see_all);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Dessert");
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView5 = view.findViewById(R.id.recyclerView5);
        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(layoutManager5);
        RecyclerViewAdapter adapter5 = new RecyclerViewAdapter(getContext(), cafeName,cafeUrl);
        recyclerView5.setAdapter(adapter5);

        textView5 = (TextView) view.findViewById(R.id.cafedrinks_see_all);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Cafe and Drinks");
                intent.putExtra("city", "Tuscany");
                intent.putExtra("table", "tuscany");
                startActivity(intent);
            }
        });
        return view;

    }



    private void getImages()
    {
        mImageUrls.add("https://i.ibb.co/6HwmN3R/pizza.png");
        mNames.add("Pizza");

        mImageUrls.add("https://i.ibb.co/h9rb2L9/burger.jpg");
        mNames.add("Burger");

        mImageUrls.add("https://i.ibb.co/BsFsNnM/fish.jpg");
        mNames.add("Fish and Chips");

        mImageUrls.add("https://i.ibb.co/vPf7rz3/foodcourt.jpg");
        mNames.add("Food Court");
    }

    private void getRes()
    {
        resUrl.add("https://i.ibb.co/7RMT80b/res.jpg");
        resName.add("Restaurants");

        resUrl.add("https://i.ibb.co/nfpKbMC/steakhouse.jpg");
        resName.add("Steakhouse");

        resUrl.add("https://i.ibb.co/th7mRZn/ramen.jpg");
        resName.add("Ramen");

        resUrl.add("https://i.ibb.co/cyL2Hw4/gourmet.jpg");
        resName.add("Gourmet");
    }

    private void getBakery()
    {
        bakeryUrl.add("https://i.ibb.co/BKVmLrb/bakery.jpg");
        bakeryName.add("Bakery");

        bakeryUrl.add("https://i.ibb.co/6yT2BhG/croissant.jpg");
        bakeryName.add("Croissant");

        bakeryUrl.add("https://i.ibb.co/ZJhzFCX/breakfast.jpg");
        bakeryName.add("Breakfast");

        bakeryUrl.add("https://i.ibb.co/KhHS2v2/bagel.jpg");
        bakeryName.add("Bagel");
    }


    private void getDessert()
    {
        dessertUrl.add("https://i.ibb.co/LYShXpn/dessert.jpg");
        dessertName.add("Dessert");

        dessertUrl.add("https://i.ibb.co/VqH0Qvd/icecream.jpg");
        dessertName.add("Ice Cream");

        dessertUrl.add("https://i.ibb.co/bvZqcTS/cookies.jpg");
        dessertName.add("Cookies");

    }

    private void getCafe()
    {
        cafeUrl.add("https://i.ibb.co/M6RyTpw/cafe.jpg");
        cafeName.add("Cafe");

        cafeUrl.add("https://i.ibb.co/QmDYkpd/coffee.jpg");
        cafeName.add("Coffee");

        cafeUrl.add("https://i.ibb.co/9pnbDbT/tea.jpg");
        cafeName.add("Tea");

    }


}
