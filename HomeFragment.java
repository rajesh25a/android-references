package com.example.hashdash.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hashdash.MainActivity;
import com.example.hashdash.MainActivity2;
import com.example.hashdash.R;


public class HomeFragment extends Fragment {
    TextView back_tv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, container, false);
        back_tv =(TextView) rootView.findViewById(R.id.nav_back_tv);
        back_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigate back to MAin activity 2 on back pressed
                ((MainActivity2)getActivity()).onBackPressed();
            }
        });
        return rootView;
    }
}