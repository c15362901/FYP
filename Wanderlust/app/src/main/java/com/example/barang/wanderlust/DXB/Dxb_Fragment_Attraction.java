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

public class Dxb_Fragment_Attraction extends Fragment {

    public Dxb_Fragment_Attraction() {
        // Required empty public constructor
    }

    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    private ArrayList<String> religiousName = new ArrayList<>();
    private ArrayList<String> religiousUrl = new ArrayList<>();

    private ArrayList<String> artsName = new ArrayList<>();
    private ArrayList<String> artsUrl = new ArrayList<>();

    private ArrayList<String> sportsName = new ArrayList<>();
    private ArrayList<String> sportsUrl = new ArrayList<>();

    private ArrayList<String> recreationalName = new ArrayList<>();
    private ArrayList<String> recreationalUrl = new ArrayList<>();


    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    Cursor c;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.attraction, container, false);

        getImages();
        getReligious();
        getArts();
        getSports();
        getRecreational();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mNames, mImageUrls);
        recyclerView.setAdapter(adapter);

        textView = (TextView) view.findViewById(R.id.nightlife_see_all);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Nightlife");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(layoutManager2);
        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(getContext(), religiousName, religiousUrl);
        recyclerView2.setAdapter(adapter2);

        textView2 = (TextView) view.findViewById(R.id.religious_see_all);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Religious");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView3 = view.findViewById(R.id.recyclerView3);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(layoutManager3);
        RecyclerViewAdapter adapter3 = new RecyclerViewAdapter(getContext(),  artsName, artsUrl);
        recyclerView3.setAdapter(adapter3);

        textView3 = (TextView) view.findViewById(R.id.artsmusic_see_all);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Arts and Music");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView4 = view.findViewById(R.id.recyclerView4);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager4);
        RecyclerViewAdapter adapter4 = new RecyclerViewAdapter(getContext(), sportsName, sportsUrl);
        recyclerView4.setAdapter(adapter4);

        textView4 = (TextView) view.findViewById(R.id.sports_see_all);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Sports");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView5 = view.findViewById(R.id.recyclerView5);
        RecyclerView.LayoutManager layoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView5.setLayoutManager(layoutManager5);
        RecyclerViewAdapter adapter5 = new RecyclerViewAdapter(getContext(), recreationalName, recreationalUrl);
        recyclerView5.setAdapter(adapter5);

        textView5 = (TextView) view.findViewById(R.id.recreational_see_all);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "Recreational");
                intent.putExtra("city", "Dubai");
                intent.putExtra("table", "dubai");
                startActivity(intent);
            }
        });
        return view;

    }

    private void getImages() {
        mImageUrls.add("https://i.ibb.co/8B2nKfk/dandelyan.jpg");
        mNames.add("Bars");

        mImageUrls.add("https://i.ibb.co/nPwWg5q/motherkellys.jpg");
        mNames.add("Pubs");

        mImageUrls.add("https://i.ibb.co/zXBQrzR/egglondon.jpg");
        mNames.add("Club");

        mImageUrls.add("https://i.ibb.co/WycHTfw/montezuma.jpg");
        mNames.add("Nightlife");

        mImageUrls.add("https://i.ibb.co/s9Sjqg1/casino.jpg");
        mNames.add("Casino");
    }


    private void getReligious() {
        religiousUrl.add("https://i.ibb.co/6n39WdZ/church.jpg");
        religiousName.add("Church");

        religiousUrl.add("https://i.ibb.co/qY0qyLH/synagogue.jpg");
        religiousName.add("Synagogue");

        religiousUrl.add("https://i.ibb.co/YXzjqVy/mosque.jpg");
        religiousName.add("Mosque");

    }

    private void getArts() {
        artsUrl.add("https://i.ibb.co/3czh1Mc/theater.jpg");
        artsName.add("Theatre");

        artsUrl.add("https://i.ibb.co/g6vpmLQ/gallery.jpg");
        artsName.add("Gallery");

        artsUrl.add("https://i.ibb.co/nCmshkT/music.jpg");
        artsName.add("Music Hall");

        artsUrl.add("https://i.ibb.co/YhG5YGm/auditorium.jpg");
        artsName.add("Auditorium");
    }

    private void getSports() {
        sportsUrl.add("https://i.ibb.co/1QqqhVr/athletics.jpg");
        sportsName.add("Athletics Stadium");

        sportsUrl.add("https://i.ibb.co/fthpJbh/tennis.jpg");
        sportsName.add("Tennis Court");

        sportsUrl.add("https://i.ibb.co/LvhhV65/bball.jpg");
        sportsName.add("Basketball Arena");

        sportsUrl.add("https://i.ibb.co/WkfCnpt/cricket.jpg");
        sportsName.add("Cricket Ground");

    }


    private void getRecreational() {
        recreationalUrl.add("https://i.ibb.co/wyh6vCh/park.jpg");
        recreationalName.add("Park");

        recreationalUrl.add("https://i.ibb.co/kXG5510/zoo.jpg");
        recreationalName.add("Zoo");

        recreationalUrl.add("https://i.ibb.co/qg2fSZ9/garden.jpg");
        recreationalName.add("Garden");

        recreationalUrl.add("https://i.ibb.co/fHn39gq/mall.jpg");
        recreationalName.add("Mall");
    }

}

