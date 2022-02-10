package com.example.felonyreporter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MissingRVAdapter extends RecyclerView.Adapter<missingViewHolder> {

    private Context context;
    private ArrayList<MissingRVModal> missingRVModalArrayList;

    public MissingRVAdapter(Context context, ArrayList<MissingRVModal> missingRVModalArrayList) {
        this.context = context;
        this.missingRVModalArrayList = missingRVModalArrayList;
    }

    @NonNull
    @Override
    public missingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new missingViewHolder(LayoutInflater.from(context).inflate(R.layout.missing_rv_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull missingViewHolder holder, int position) {
        MissingRVModal missingRVModal=missingRVModalArrayList.get(position);
        holder.mname1.setText("Name :"+missingRVModal.getName());
        holder.mcity1.setText("City :"+missingRVModal.getCity());
        holder.mstate1.setText("State :"+missingRVModal.getState());
        holder.mpin1.setText("PinCode :"+missingRVModal.getPincode());
        holder.mdesc1.setText("Description :"+missingRVModal.getPerdes());
        Picasso.get().load(missingRVModal.getImage()).into(holder.mimage1);

    }

    @Override
    public int getItemCount() {
        return missingRVModalArrayList.size();
    }
}
