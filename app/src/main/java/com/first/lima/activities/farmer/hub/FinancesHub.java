package com.first.lima.activities.farmer.hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.first.lima.R;
import com.first.lima.activities.farmer.hub.adapter.FinanceAdapter;
import com.first.lima.activities.farmer.hub.adapter.GrowAdapter;
import com.first.lima.activities.farmer.hub.model.Financemodel;
import com.first.lima.activities.farmer.hub.model.Growmodel;

import java.util.ArrayList;
import java.util.List;

public class FinancesHub extends AppCompatActivity {
    //list to store details
    List<Financemodel> financemodelList;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finances_hub);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycleFinance);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //initializing the productlist
        financemodelList = new ArrayList<>();
        //creating recyclerview adapter
        //adding some items to our list
        financemodelList.add(
                new Financemodel(
                        "ABC",
                        "we offer credit services for farmers",
                         "0798501657",
                         R.drawable.credit


                ));

        financemodelList.add(
                new Financemodel(
                        "CBA",
                        "we offer insurance for farm products",
                         "0734724283",
                         R.drawable.sure

                ));
        //creating recyclerview adapter
        FinanceAdapter adapter = new FinanceAdapter(this, financemodelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
