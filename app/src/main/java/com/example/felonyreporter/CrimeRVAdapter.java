package com.example.felonyreporter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CrimeRVAdapter extends RecyclerView.Adapter<crimeViewHolder>{

    private Context context;
    private ArrayList<CrimeRVModal> crimeRVModalArrayList;
    
    public CrimeRVAdapter(Context context, ArrayList<CrimeRVModal> crimeRVModalArrayList) {
        this.context = context;
        this.crimeRVModalArrayList = crimeRVModalArrayList;
    }

    @NonNull
    @Override
    public crimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new crimeViewHolder(LayoutInflater.from(context).inflate(R.layout.crime_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull crimeViewHolder holder, int position) {
    CrimeRVModal crimeRVModal=crimeRVModalArrayList.get(position);
    holder.cid1.setText("Id: "+crimeRVModal.getCrimeid());
    holder.city1.setText("City: "+crimeRVModal.getCity());
    holder.cstate1.setText("State: "+crimeRVModal.getState());
    holder.cpin1.setText("Pincode: "+crimeRVModal.getPincode());
    holder.cdes1.setText("Description: "+crimeRVModal.getCrimedesc());


    }

    @Override
    public int getItemCount() {
        return crimeRVModalArrayList.size();
    }
}
