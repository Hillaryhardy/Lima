package com.first.lima.activities.farmer.hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.first.lima.R;
import com.first.lima.activities.farmer.hub.adapter.GrowAdapter;
import com.first.lima.activities.farmer.hub.adapter.LabourAdapter;
import com.first.lima.activities.farmer.hub.model.Growmodel;
import com.first.lima.activities.farmer.hub.model.LabourModel;

import java.util.ArrayList;
import java.util.List;

public class LabourHub extends AppCompatActivity {
    //list to store details
    List<LabourModel> labourModelList;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labour_hub);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycleLabour);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        labourModelList = new ArrayList<>();
        //creating recyclerview adapter
        //adding some items to our list
        labourModelList.add(
                new LabourModel(
                        "Joseph Mbugua",
                        "I want to lease my land for farming activities especially tomato farming",
                        "Umoja, Nairobi",
                        "3 years at 100,000 per year",
                        "0798501657"


                ));

        labourModelList.add(
                new LabourModel(
                        "Allan Allen",
                        "Lease land for rice irrigation",
                        "Nyeri Central, Nyeri County",
                        "2 years at 50,000 per year",
                        "0734724283"


                ));
        //creating recyclerview adapter
        LabourAdapter adapter = new LabourAdapter(this, labourModelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
