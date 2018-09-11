package com.training.viewpagertest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    int index;

    public PagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("Fragment2");
        textView.setTextColor(Color.RED);
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fragment> fragments = getFragmentManager().getFragments();

                fragments.remove(index);
                Fragment1 fragment1 = new Fragment1();
                fragment1.adapter = adapter;
                fragment1.index = index;

                fragments.add(index, fragment1);

                adapter.fragments.clear();
                adapter.fragments = (ArrayList<Fragment>) fragments;

                adapter.notifyDataSetChanged();
            }
        });
        return textView;
    }
}
