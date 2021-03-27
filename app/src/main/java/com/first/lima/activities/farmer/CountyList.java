package com.first.lima.activities.farmer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.first.lima.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class CountyList extends AppCompatActivity {
    String items [] = new String[]{
            "Baringo","Bomet", "Busia", "Elgeyo Marakwet", "Embu",
            "Garissa", "Homabay", "Isiolo", "Kajiado", "Kakamega",
            "Kericho", "Kiambu", "Kilifi","Kirinyaga","Kisii",
            "Kisumu","Kitui","Kwale","Laikipia","Lamu","Machakos",
            "Makueni","Mandera","Marsabit","Meru","Migori","Mombasa",
            "Murang'a","Nairobi","Nakuru","Nandi","Narok","Nyamira",
            "Nyandarua","Nyeri","Samburu","Siaya","Taita Taveta",
            "Tana River","Trans Nzoia","Tharaka Nithi","Turkana",
            "Uasin Gishu","Vihiga","Wajir","West Pokot"

    };
    ListView listview;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_county_list);

        //toast message when user launches app
        Toast toast=Toast.makeText(getApplicationContext(),"Select County", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
        toast.show();

        //listview
        ListView listview = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,items);
        // Get Active listView
//        listview.setBackground(getDrawable(R.drawable.greenish));
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //getting list item selected
                String itemClicked = items[position].toString();
                Intent intent  = new Intent (CountyList.this, CropsCounty.class);
                intent.putExtra("listItemClicked", itemClicked);
                startActivity(intent);
            }

        });

    }
}
