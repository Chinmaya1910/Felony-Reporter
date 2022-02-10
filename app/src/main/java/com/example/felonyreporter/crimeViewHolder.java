package com.example.felonyreporter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class crimeViewHolder  extends RecyclerView.ViewHolder {
    public TextView cid1,cdes1,city1,cstate1,cpin1;
    public CardView card1;


    public crimeViewHolder(@NonNull View itemView) {
        super(itemView);
        cid1=itemView.findViewById(R.id.cid);
        cdes1=itemView.findViewById(R.id.cdes);
        city1=itemView.findViewById(R.id.ccity);
        cstate1=itemView.findViewById(R.id.cstate);
        cpin1=itemView.findViewById(R.id.cpin);
        card1=itemView.findViewById(R.id.ccard);

    }
}
