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
import com.first.lima.activities.farmer.hub.model.Diseasemodel;
import com.first.lima.activities.farmer.hub.model.Financemodel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FinanceAdapter extends RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder> {
    public Financemodel financemodel;
    private Context context;
    private List<Financemodel> financemodelList;

    public FinanceAdapter(Context context,List<Financemodel> financemodelList){
        this.context = context;
        this.financemodelList = financemodelList;
    }

    @NonNull
    @Override
    public FinanceAdapter.FinanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.financehub, null);
        return new FinanceAdapter.FinanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FinanceAdapter.FinanceViewHolder holder, int position) {
        financemodel = financemodelList.get(position);
        //loading the image
        Glide.with(context)
                .load(financemodel.getInstitutionImage())
                .into(holder.imageView);
        //bind the data to viewholders
        holder.institutionName.setText(String.valueOf(financemodel.getInstitutionName()));
        holder.institutionDesc.setText(String.valueOf(financemodel.getInstitutionDesc()));
        holder.btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://josephbill.github.io/"));
                context.startActivity(browserIntent);
            }
        });
        holder.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ financemodel.getInstitutionPhone()));
                    context.startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(context, "An error occured, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return financemodelList.size();
    }

    class FinanceViewHolder extends RecyclerView.ViewHolder{
        TextView institutionName, institutionDesc;
        Button btnContact,btnWeb;
        ImageView imageView;


        public FinanceViewHolder(View itemView){
            super(itemView);

            institutionName = itemView.findViewById(R.id.institutionName);
            institutionDesc = itemView.findViewById(R.id.institutionDesc);
            btnContact = itemView.findViewById(R.id.btnContact);
            btnWeb = itemView.findViewById(R.id.btnWeb);
            imageView = itemView.findViewById(R.id.financeimage);


        }
    }
}
