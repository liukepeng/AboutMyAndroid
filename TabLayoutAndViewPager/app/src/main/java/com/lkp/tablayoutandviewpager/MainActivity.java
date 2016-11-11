package com.lkp.tablayoutandviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAB_NAME_1 = "one";
    private static final String TAB_NAME_2 = "two";
    private static final String TAB_NAME_3 = "three";
    private List<String> tabNames;
    private List<BaseFragment> fragments;
    private List<Integer> tabIcs;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        initTablayoutAndViewPager();
    }

    private void initTablayoutAndViewPager(){
        tabNames = new ArrayList<>();
        fragments = new ArrayList<>();
        tabIcs = new ArrayList<>();
        tabNames.add(TAB_NAME_1);
        tabNames.add(TAB_NAME_2);
        tabNames.add(TAB_NAME_3);

        tabIcs.add(R.mipmap.ic_launcher);
        tabIcs.add(R.mipmap.ic_launcher);
        tabIcs.add(R.mipmap.ic_launcher);

        OneFragment oneFragment = new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        fragments.add(oneFragment);
        fragments.add( twoFragment);
        fragments.add( threeFragment);

        ViewPagerAndTabLayoutAdapter adapter = new ViewPagerAndTabLayoutAdapter(getSupportFragmentManager(),this, tabNames,fragments,tabIcs);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
