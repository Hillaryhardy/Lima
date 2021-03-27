package com.first.lima.activities.farmer.hub.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.first.lima.R;
import com.first.lima.activities.farmer.hub.model.Growmodel;
import com.first.lima.activities.farmer.hub.model.Marketmodel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {

    public Marketmodel marketmodel;
    //context to inflate the layout
    private Context mCtx;
    //store hospital dat in this list
    private List<Marketmodel> marketmodelList;
    //getting the context and product list with constructor
    public MarketAdapter(Context mCtx, List<Marketmodel> marketmodelList){
        this.mCtx = mCtx;
        this.marketmodelList = marketmodelList;
    }

    @NonNull
    @Override
    public MarketAdapter.MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.markethub, null);
        return new MarketAdapter.MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketAdapter.MarketViewHolder holder, int position) {
        //getting details to specified position
        marketmodel = marketmodelList.get(position);
        //binding the data to viewholders
        holder.name.setText(String.valueOf(marketmodel.getClientName()));
        holder.order.setText(String.valueOf(marketmodel.getOrder()));
        holder.location.setText(String.valueOf(marketmodel.getLocation()));
        holder.status.setText(String.valueOf(marketmodel.getStatus()));
        holder.btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ marketmodel.getPhone()));
                    mCtx.startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(mCtx, "An error occured, please try again", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return marketmodelList.size();
    }

    class MarketViewHolder extends RecyclerView.ViewHolder {

        TextView name,order,location,status;
        Button btnPhone;

        public MarketViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvClientName);
            order = itemView.findViewById(R.id.tvOrder);
            location = itemView.findViewById(R.id.tvLocation);
            status = itemView.findViewById(R.id.tvStatus);
            btnPhone = itemView.findViewById(R.id.btnPhone);
        }
    }
}
