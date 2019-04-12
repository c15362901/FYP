package com.example.barang.wanderlust.DXB;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.barang.wanderlust.AMS.Ams_Fragment_Accommodation;
import com.example.barang.wanderlust.AMS.Ams_Fragment_Attraction;
import com.example.barang.wanderlust.AMS.Ams_Fragment_POI;
import com.example.barang.wanderlust.AMS.Ams_Fragment_Restaurant;
import com.example.barang.wanderlust.R;

import java.util.ArrayList;
import java.util.List;

public class Dxb_HomePage extends Fragment {

    public static Dxb_HomePage newInstance(){
        Dxb_HomePage homepage = new Dxb_HomePage();

        return homepage;
    }

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tab_icons = {
            R.drawable.hotel,
            R.drawable.tour,
            R.drawable.food,
            R.drawable.poi
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View RootView = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar)RootView.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText("Dubai");
        viewPager = (ViewPager)RootView.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)RootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabIcons();

        return RootView;
    }


    private void tabIcons()
    {
        tabLayout.getTabAt(0).setIcon(tab_icons[0]);
        tabLayout.getTabAt(1).setIcon(tab_icons[1]);
        tabLayout.getTabAt(2).setIcon(tab_icons[2]);
        tabLayout.getTabAt(3).setIcon(tab_icons[3]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Dxb_Fragment_Accommodation(), "Accommodation");
        adapter.addFragment(new Dxb_Fragment_Attraction(), "Attraction");
        adapter.addFragment(new Dxb_Fragment_Restaurant(), "Restaurant");
        adapter.addFragment(new Dxb_Fragment_POI(), "Point of Interest");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
