package com.example.hashdash.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hashdash.R;

public class OrderFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= LayoutInflater.from(getContext()).inflate(R.layout.fragment_order,container,false);
        return rootView;
    }
}