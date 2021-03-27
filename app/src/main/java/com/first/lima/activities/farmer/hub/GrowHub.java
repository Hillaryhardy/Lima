package com.first.lima.activities.farmer.hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.first.lima.R;
import com.first.lima.activities.farmer.hub.adapter.GrowAdapter;
import com.first.lima.activities.farmer.hub.model.Growmodel;

import java.util.ArrayList;
import java.util.List;

public class GrowHub extends AppCompatActivity {
    //list to store details
    List<Growmodel> growmodelList;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grow_hub);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycleGrow);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        growmodelList = new ArrayList<>();

        //creating recyclerview adapter
        //adding some items to our list
        growmodelList.add(
                new Growmodel(
                        "Ecological Conditions",
                        "Climatic conditions necessary for growth of crop.",
                        R.drawable.weather

                ));

        growmodelList.add(
                new Growmodel(
                        "Equipments",
                        "Tools used for planting of crop",
                        R.drawable.equip

                ));
        growmodelList.add(
                new Growmodel(
                        "Planting",
                        "How to plant the crop",
                        R.drawable.plant

                ));
        growmodelList.add(
                new Growmodel(
                        "Weeding",
                        "Remove unwanted plants from (an area of ground)",
                        R.drawable.weeds

                ));
        growmodelList.add(
                new Growmodel(
                        "Harvesting",
                        "How to harvest ready crop",
                        R.drawable.harvest

                ));
        growmodelList.add(
                new Growmodel(
                        "Post Harvest Handling",
                        "Best practices in the storage of crop",
                        R.drawable.storage

                ));
        //creating recyclerview adapter
        GrowAdapter adapter = new GrowAdapter(this, growmodelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}
