package com.first.lima.activities.farmer.hub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.first.lima.R;
import com.first.lima.activities.farmer.hub.model.Growmodel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GrowAdapter extends RecyclerView.Adapter<GrowAdapter.GrowViewHolder> {

    public Growmodel growmodel;
    //context to inflate the layout
    private Context mCtx;
    //store hospital dat in this list
    private List<Growmodel> growmodelList;
    //getting the context and product list with constructor
    public GrowAdapter(Context mCtx, List<Growmodel> growmodelList){
        this.mCtx = mCtx;
        this.growmodelList = growmodelList;
    }

    @NonNull
    @Override
    public GrowAdapter.GrowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.growhub, null);
        return new GrowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrowAdapter.GrowViewHolder holder, int position) {
        //getting details to specified position
        growmodel = growmodelList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(growmodel.getImage())
                .into(holder.imgcat);
        //binding the data to viewholders
        holder.namecat.setText(String.valueOf(growmodel.getCatname()));
        holder.descCat.setText(String.valueOf(growmodel.getCatdescription()));
    }


    @Override
    public int getItemCount() {
        return growmodelList.size();
    }

    class GrowViewHolder extends RecyclerView.ViewHolder {

        TextView namecat,descCat;
        ImageView imgcat;

        public GrowViewHolder(View itemView) {
            super(itemView);

            namecat = itemView.findViewById(R.id.tvTitle);
            imgcat = itemView.findViewById(R.id.imagelogo);
            descCat = itemView.findViewById(R.id.tv_desc);
        }
    }
}
