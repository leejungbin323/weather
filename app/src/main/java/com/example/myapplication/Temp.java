package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Temp extends Fragment {
    TextView temp_tv;
    public Temp() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        temp_tv = container.findViewById(R.id.t);
        temp_tv.setText(MainActivity.tem);
        return inflater.inflate(R.layout.fragment_temp, container, false);
    }
}