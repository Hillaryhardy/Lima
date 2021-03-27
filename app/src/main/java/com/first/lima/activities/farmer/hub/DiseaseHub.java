package com.first.lima.activities.farmer.hub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.first.lima.R;
import com.first.lima.activities.farmer.hub.adapter.DiseaseAdapter;
import com.first.lima.activities.farmer.hub.adapter.GrowAdapter;
import com.first.lima.activities.farmer.hub.model.Diseasemodel;
import com.first.lima.activities.farmer.hub.model.Growmodel;

import java.util.ArrayList;
import java.util.List;

public class DiseaseHub extends AppCompatActivity {
    //list to store details
    List<Diseasemodel> diseasemodelList;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_hub);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycleDisease);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        diseasemodelList = new ArrayList<>();

        //creating recyclerview adapter
        //adding some items to our list
        diseasemodelList.add(
                new Diseasemodel(
                        "Thirps",
                        "Thrips are minute, slender insects with fringed wings and unique asymmetrical mouthparts. Different thrips species feed mostly on plants by puncturing and sucking up the contents, although a few are predators",
                        "Thrips are difficult to control. If management is necessary, use an integrated program that combines the use of good cultural practices, natural enemies, and the most selective or least-toxic insecticides that are effective in that situation.",
                         R.drawable.thirps

                ));

        diseasemodelList.add(
                new Diseasemodel(
                        "Army Worms",
                        "Spodoptera is a genus of moths of the family Noctuidae first described by Achille Guenée in 1852. Many are known as pest insects",
                        "Remove weeds from fields and surrounding areas.",
                         R.drawable.armyworm


                ));
        diseasemodelList.add(
                new Diseasemodel(
                        "White Fly",
                        "Whiteflies are Hemipterans that typically feed on the undersides of plant leaves",
                        "If found, use the Bug Blaster to hose off plants with a strong stream of water and reduce pest numbers.",
                         R.drawable.whitefly


                ));

        //creating recyclerview adapter
        DiseaseAdapter adapter = new DiseaseAdapter(this, diseasemodelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
