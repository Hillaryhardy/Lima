package com.first.lima.activities.farmer.hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.first.lima.R;
import com.first.lima.activities.farmer.hub.adapter.GrowAdapter;
import com.first.lima.activities.farmer.hub.adapter.MarketAdapter;
import com.first.lima.activities.farmer.hub.model.Growmodel;
import com.first.lima.activities.farmer.hub.model.Marketmodel;

import java.util.ArrayList;
import java.util.List;

public class MarketHub extends AppCompatActivity {
    //list to store details
    List<Marketmodel> marketmodelList;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_hub);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycleMarket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        marketmodelList = new ArrayList<>();
        //creating recyclerview adapter
        //adding some items to our list
        marketmodelList.add(
                new Marketmodel(
                        "Joseph Mbugua",
                        "8 bags of Kale",
                        "Umoja,Nairobi",
                        "active",
                        "0798501657"


                ));

        marketmodelList.add(
                new Marketmodel(
                        "Bill Joseph",
                        "2 bags of potatoes",
                        "Westlands,Nairobi",
                        "active",
                        "0734724283"


                ));
        //creating recyclerview adapter
        MarketAdapter adapter = new MarketAdapter(this, marketmodelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
