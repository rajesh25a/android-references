package com.example.fininfocom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<UserDataModal> dataModalArrayList ;

    public MyAdapter(ArrayList<UserDataModal> dataModalArrayList) {
        this.dataModalArrayList = dataModalArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.name.setText(dataModalArrayList.get(position).getName());

       // holder.age.setText(dataModalArrayList.get(position).getAge());
        holder.city.setText(dataModalArrayList.get(position).getCity());

    }

    @Override
    public int getItemCount() {
        return dataModalArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,age, city;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //name , age, city
            name = itemView.findViewById(R.id.name_tv);
            //age = itemView.findViewById(R.id.age_tv);
            city =itemView.findViewById(R.id.city_tv);

        }
    }
}
