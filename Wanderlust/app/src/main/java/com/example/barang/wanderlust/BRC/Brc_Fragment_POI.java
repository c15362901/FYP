package com.example.barang.wanderlust.BRC;

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

public class Brc_Fragment_POI extends Fragment {

    public Brc_Fragment_POI() {
        // Required empty public constructor
    }

    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private ArrayList<String> monumentName = new ArrayList<>();
    private ArrayList<String> monumentUrl = new ArrayList<>();

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
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
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
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
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
                intent.putExtra("city", "Barcelona");
                intent.putExtra("table", "barcelona");
                startActivity(intent);
            }
        });
        return view;

    }

    private void getImages()
    {
        mImageUrls.add("https://i.ibb.co/tD9QfhW/catalunya.jpg");
        mNames.add("Biblioteca de Catalunya");

        mImageUrls.add("https://i.ibb.co/vh7HqkC/garcilaso.jpg");
        mNames.add("Biblioteca de Garcilaso");

        mImageUrls.add("https://i.ibb.co/vj53T25/sala.jpg");
        mNames.add("Sala de Lectura del Clot");
    }

    private void getMonument()
    {
        monumentUrl.add("https://i.ibb.co/0Z6ckmm/virreina.jpg");
        monumentName.add("Palau de la Virreina");

        monumentUrl.add("https://i.ibb.co/GMFWGGd/Temple.jpg");
        monumentName.add("Temple d'August");

        monumentUrl.add("https://i.ibb.co/Wk9KNf0/Refugi.jpg");
        monumentName.add("Refugi 307");

        monumentUrl.add("https://i.ibb.co/R4bMrg7/Torres.jpg");
        monumentName.add("Torres Venecianes");
    }

    private void getConv()
    {
        convUrl.add("https://i.ibb.co/1L8m5Xz/Fira.jpg");
        convName.add("Fira de Barcelona");

        convUrl.add("https://i.ibb.co/GHCPHHX/WTC.jpg");
        convName.add("World Trade Center");

        convUrl.add("https://i.ibb.co/cw5TC8m/Mobile.jpg");
        convName.add("Mobile World Center");

    }

}