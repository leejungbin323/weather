package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Wind extends Fragment {
    TextView wind_tv;
    public Wind() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        wind_tv = container.findViewById(R.id.wind);
        wind_tv.setText(MainActivity.W);
        return inflater.inflate(R.layout.fragment_wind, container, false);
    }
}