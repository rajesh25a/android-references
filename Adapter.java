package com.example.reccylerview.Adapter;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reccylerview.R;
import com.example.reccylerview.modal.DataBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
ArrayList<DataBean> mArrayList ;

    public Adapter(ArrayList<DataBean> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(mArrayList.get(position).getImage());
        holder.tv.setText(mArrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.image);
            tv = (TextView) itemView.findViewById(R.id.tv);

        }
    }
}
