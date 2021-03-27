package com.first.lima.activities.farmer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.first.lima.R;
import com.first.lima.activities.MainDashboard;
import com.first.lima.activities.farmer.hub.DiseaseHub;
import com.first.lima.activities.farmer.hub.FinancesHub;
import com.first.lima.activities.farmer.hub.GrowHub;
import com.first.lima.activities.farmer.hub.LabourHub;
import com.first.lima.activities.farmer.hub.MarketHub;
import com.first.lima.activities.landowner.onboarding.OnBoarding;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CropHub extends AppCompatActivity {
    String items [] = new String[]{
            "How To Grow","Diseases and Pest Management","Financial Information","Market Information", "Labour Opportunities"


    };
    ListView listview;
    TextView tvLogo;
    String cropname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_hub);

        //toast message when user launches app
        Toast toast=Toast.makeText(getApplicationContext(),"Select Topic", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
        toast.show();
        Intent intent = getIntent();
        cropname=intent.getStringExtra("listItemClicked");
        tvLogo=findViewById(R.id.tvLogo);
        tvLogo.setText("All you need to know about "+cropname);

        listview = findViewById(R.id.hubList);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,items);
        // Get Active listView
//        listview.setBackground(getDrawable(R.drawable.greenish));
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(CropHub.this, GrowHub.class);
                    startActivityForResult(intent, 0);
                }
                if (position == 1) {
                    Intent intent = new Intent(CropHub.this, DiseaseHub.class);
                    startActivityForResult(intent, 1);
                }
                if (position == 2){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(CropHub.this);
                    dialog.setCancelable(true);
                    dialog.setTitle("Financial Information");
                    dialog.setMessage("Agricultural Credit and Insurance info");
                    dialog.setPositiveButton(Html.fromHtml("<font color='#0737d4'>Proceed</font>"), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(CropHub.this, FinancesHub.class);
                            startActivity(intent);
                        }
                    });
                    dialog.setNegativeButton(android.R.string.no,null).show();
                }
                if (position == 3){
                    Intent intent = new Intent(CropHub.this, MarketHub.class);
                    startActivityForResult(intent, 3);
                }
                if (position == 4){
                    Intent intent = new Intent(CropHub.this, LabourHub.class);
                    startActivityForResult(intent, 4);
                }
            }

        });
    }
}
