package com.first.lima.activities.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.first.lima.R;

import androidx.appcompat.app.AppCompatActivity;

public class CropsCounty extends AppCompatActivity {
    String items[] = new String[]{
            "Maize", "Beans", "Kales/Sukuma Wiki", "Cabbage", "Tomatoes"


    };
    ListView listview;
    TextView tvLogo;
    String countyName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops_county);

        //toast message when user launches app
        Toast toast = Toast.makeText(getApplicationContext(), "Select crop", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
        toast.show();
        Intent intent = getIntent();
        countyName=intent.getStringExtra("listItemClicked");
        tvLogo=findViewById(R.id.tvLogo);
        tvLogo.setText("Crops favourable for growth in "+countyName);

        listview = findViewById(R.id.cropList);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        // Get Active listView
//        listview.setBackground(getDrawable(R.drawable.greenish));
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting list item selected
                String itemClicked = items[i].toString();
                Intent intent  = new Intent (CropsCounty.this, CropHub.class);
                intent.putExtra("listItemClicked", itemClicked);
                startActivity(intent);
            }
        });
    }
}
