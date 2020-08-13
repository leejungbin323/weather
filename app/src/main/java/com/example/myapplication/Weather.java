package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Weather extends Fragment {
    TextView weather_tv;
    public Weather() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        weather_tv = container.findViewById(R.id.weather);
        weather_tv.setText(MainActivity.w);
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }
}