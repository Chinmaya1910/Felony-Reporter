package com.example.felonyreporter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class missingViewHolder extends RecyclerView.ViewHolder {
    public TextView mname1,mcity1,mstate1,mpin1,mdesc1;
    public ImageView mimage1;
    public CardView card2;
    public missingViewHolder(@NonNull View itemView){
        super(itemView);
        mname1=itemView.findViewById(R.id.mname);
        mcity1=itemView.findViewById(R.id.mcity);
        mstate1=itemView.findViewById(R.id.mstate);
        mpin1=itemView.findViewById(R.id.mpin);
        mdesc1=itemView.findViewById(R.id.mdesc);

        mimage1=itemView.findViewById(R.id.mimage);

        card2=itemView.findViewById(R.id.mcard);



    }
}
