package com.example.fininfocom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<UserDataModal> dataModalArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recyclerView_id);

        dataModalArrayList.add(new UserDataModal("Rajesh","EC4",24));
        dataModalArrayList.add(new UserDataModal("Ajay","VZM",18));
        dataModalArrayList.add(new UserDataModal("Anil","KDP",35));
        dataModalArrayList.add(new UserDataModal("Uday","ELR",23));
        dataModalArrayList.add(new UserDataModal("Rama","VSKP",21));
        dataModalArrayList.add(new UserDataModal("Sai teja","VJY",32));
        dataModalArrayList.add(new UserDataModal("Krishna","RJY",34));
        dataModalArrayList.add(new UserDataModal("Swaroop","PPM",54));
        dataModalArrayList.add(new UserDataModal("Rohith","GPNM",23));
        dataModalArrayList.add(new UserDataModal("Sai","BBL",22));
        dataModalArrayList.add(new UserDataModal("Dileep","SLR",33));

        adapter = new MyAdapter(dataModalArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}