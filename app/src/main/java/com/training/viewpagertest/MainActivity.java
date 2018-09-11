package com.training.viewpagertest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    PagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initAdapter();

        tabLayout.setupWithViewPager(pager);
    }

    private void initAdapter() {
        adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.fragments = initFragments();
        pager.setAdapter(adapter);
    }

    private void initView() {
        tabLayout = findViewById(R.id.tablayout);
        pager = findViewById(R.id.pager);
    }

    private ArrayList<Fragment> initFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        Fragment1 frag1 = new Fragment1();
        Fragment1 frag2 = new Fragment1();

        frag1.adapter = adapter;
        frag2.adapter = adapter;

        frag1.index = 0;
        frag2.index = 1;

        fragments.add(frag1);
        fragments.add(frag2);

        return fragments;
    }
}
