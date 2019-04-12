package com.example.barang.wanderlust;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.barang.wanderlust.AMS.Ams_HomePage;
import com.example.barang.wanderlust.BER.Ber_HomePage;
import com.example.barang.wanderlust.BRC.Brc_HomePage;
import com.example.barang.wanderlust.DXB.Dxb_HomePage;
import com.example.barang.wanderlust.LDN.Ldn_HomePage;
import com.example.barang.wanderlust.PRS.Prs_HomePage;
import com.example.barang.wanderlust.ROM.Rom_HomePage;
import com.example.barang.wanderlust.TCY.Tcy_HomePage;

public class Home extends Fragment {
    public static Home newInstance(){
        Home home = new Home();
        return home;
    }

    Button amsterdam;
    Button barcelona;
    Button berlin;
    Button dubai;
    Button london;
    Button paris;
    Button rome;
    Button tuscany;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home, container, false);

        amsterdam = (Button)view.findViewById(R.id.amsterdam);
        amsterdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Ams_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(null);
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.commit();
            }

        });

        barcelona = (Button)view.findViewById(R.id.barcelona);
        barcelona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Brc_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        berlin = (Button)view.findViewById(R.id.berlin);
        berlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Ber_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        dubai = (Button)view.findViewById(R.id.dubai);
        dubai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Dxb_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        london = (Button)view.findViewById(R.id.london);
        london.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Ldn_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        paris = (Button)view.findViewById(R.id.paris);
        paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Prs_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        rome = (Button)view.findViewById(R.id.rome);
        rome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Rom_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        tuscany = (Button)view.findViewById(R.id.tuscany);
        tuscany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Tcy_HomePage();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentgroup, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }


        });

        return view;
    }



}
