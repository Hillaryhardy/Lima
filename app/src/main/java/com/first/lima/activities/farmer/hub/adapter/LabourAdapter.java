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
import com.first.lima.activities.farmer.hub.model.LabourModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LabourAdapter extends RecyclerView.Adapter<LabourAdapter.LabourViewHolder> {

    public LabourModel labourModel;
    //context to inflate the layout
    private Context mCtx;
    //store hospital dat in this list
    private List<LabourModel> labourModelList;
    //getting the context and product list with constructor
    public LabourAdapter(Context mCtx, List<LabourModel> labourModelList){
        this.mCtx = mCtx;
        this.labourModelList = labourModelList;
    }

    @NonNull
    @Override
    public LabourAdapter.LabourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.labourhub, null);
        return new LabourAdapter.LabourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabourAdapter.LabourViewHolder holder, int position) {
        //getting details to specified position
        labourModel = labourModelList.get(position);

        //binding the data to viewholders
        holder.name.setText(String.valueOf(labourModel.getName()));
        holder.service.setText(String.valueOf(labourModel.getServicedesc()));
        holder.location.setText(String.valueOf(labourModel.getLocation()));
        holder.lease.setText(String.valueOf(labourModel.getLease()));
        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ labourModel.getPhone()));
                    mCtx.startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(mCtx, "An error occured, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return labourModelList.size();
    }

    class LabourViewHolder extends RecyclerView.ViewHolder {

        TextView name,service,location,lease;
        Button btnCall;

        public LabourViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvOwner);
            service = itemView.findViewById(R.id.tvDescription);
            location = itemView.findViewById(R.id.tvFarmLocation);
            lease = itemView.findViewById(R.id.tvLease);
            btnCall = itemView.findViewById(R.id.btnPhone);
        }
    }
}
