package com.first.lima.activities.farmer.hub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.first.lima.R;
import com.first.lima.activities.farmer.hub.model.Diseasemodel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.DiseaseViewHolder> {
    public Diseasemodel diseasemodel;
    private Context context;
    private List<Diseasemodel> diseasemodelList;

    public DiseaseAdapter(Context context,List<Diseasemodel> diseasemodelList){
        this.context = context;
        this.diseasemodelList = diseasemodelList;
    }

    @NonNull
    @Override
    public DiseaseAdapter.DiseaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.diseasehub, null);
        return new DiseaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DiseaseAdapter.DiseaseViewHolder holder, int position) {
      diseasemodel = diseasemodelList.get(position);
      //loading with image
        Glide.with(context).load(diseasemodel.getDiseaseimage()).into(holder.diseaseImage);
        //bind the data to viewholders
        holder.diseaseName.setText(String.valueOf(diseasemodel.getDiseasename()));
        holder.diseaseDesc.setText(String.valueOf(diseasemodel.getDiseasedesc()));
        holder.diseaseMan.setText(String.valueOf(diseasemodel.getDiseaseman()));
        holder.btnMan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.diseaseMan.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return diseasemodelList.size();
    }

    class DiseaseViewHolder extends RecyclerView.ViewHolder{
        TextView diseaseName,diseaseDesc,diseaseMan;
        Button btnPurchase,btnMan;
        ImageView diseaseImage;

        public DiseaseViewHolder(View itemView){
            super(itemView);

            diseaseName = itemView.findViewById(R.id.diseaseName);
            diseaseDesc = itemView.findViewById(R.id.diseaseDesc);
            diseaseMan = itemView.findViewById(R.id.diseaseMan);
            diseaseImage = itemView.findViewById(R.id.diseaseImage);
            btnPurchase = itemView.findViewById(R.id.btnPurchase);
            btnMan = itemView.findViewById(R.id.btnMan);

        }
    }
}
