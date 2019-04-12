package com.example.barang.wanderlust.BER;

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

public class Ber_Fragment_POI extends Fragment {

    public Ber_Fragment_POI() {
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
        getUni();
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
                intent.putExtra("city", "Berlin");
                intent.putExtra("table", "berlin");
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
                intent.putExtra("city", "Berlin");
                intent.putExtra("table", "berlin");
                startActivity(intent);
            }
        });

        RecyclerView recyclerView4 = view.findViewById(R.id.recyclerView4);
        RecyclerView.LayoutManager layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView4.setLayoutManager(layoutManager4);
        RecyclerViewAdapter adapter4 = new RecyclerViewAdapter(getContext(), uniName, uniUrl);
        recyclerView4.setAdapter(adapter4);

        textView4 = (TextView) view.findViewById(R.id.university_see_all);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MainPage.class);
                intent.putExtra("category", "University");
                intent.putExtra("city", "Berlin");
                intent.putExtra("table", "berlin");
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
                intent.putExtra("category", "Convention Center");
                intent.putExtra("city", "Berlin");
                intent.putExtra("table", "berlin");
                startActivity(intent);
            }
        });
        return view;

    }

    private void getImages()
    {
        mImageUrls.add("https://i.ibb.co/xD2mktM/amerika.jpg");
        mNames.add("Haus Amerika-Gedenkbibliothek");

        mImageUrls.add("https://i.ibb.co/qgZYdvT/stat.jpg");
        mNames.add("Staatsbibliothek");

        mImageUrls.add("https://i.ibb.co/vBSHD3k/jacom.jpg");
        mNames.add("HU Berlin");
    }

    private void getUni()
    {
        uniUrl.add("https://i.ibb.co/Q9mhZGQ/uni.jpg");
        uniName.add("Freie Universitat Berlin");

        uniUrl.add("https://i.ibb.co/gyHBRDj/GLS.jpg");
        uniName.add("GLS Campus");
    }

    private void getMonument()
    {
        monumentUrl.add("https://i.ibb.co/w6MnMGq/brandenburger.jpg");
        monumentName.add("Brandenburger Tor");

        monumentUrl.add("https://i.ibb.co/GkQx0dy/Wasserturm.jpg");
        monumentName.add("Wasserturm");

        monumentUrl.add("https://i.ibb.co/Bc1rKQm/Frankfurter.jpg");
        monumentName.add("Frankfurter Tor");

        monumentUrl.add("https://ibb.co/4ZMrYZT/Neue.jpg");
        monumentName.add("Neue Wache");
    }

    private void getConv()
    {
        convUrl.add("https://i.ibb.co/wwbT18M/messe.jpg");
        convName.add("Messe Berlin");

        convUrl.add("https://i.ibb.co/N11MMsv/deutscher.jpg");
        convName.add("Deutscher Logistik-Kongress");

        convUrl.add("https://ibb.co/Xj4J4wB/hall18.jpg");
        convName.add("Halle 18");
    }
}
