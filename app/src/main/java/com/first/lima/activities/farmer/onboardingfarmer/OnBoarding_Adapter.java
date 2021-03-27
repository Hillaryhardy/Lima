package com.first.lima.activities.farmer.onboardingfarmer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.first.lima.R;
import com.first.lima.activities.farmer.CountyList;
import com.first.lima.activities.landowner.dashboard.LandOwnerDash;
import com.first.lima.activities.landowner.onboarding.OnBoardItem;

import java.util.ArrayList;

import androidx.viewpager.widget.PagerAdapter;

public class OnBoarding_Adapter extends PagerAdapter {

    private Context mContext;
    ArrayList<OnBoardItem_Farmer> onBoardItem_farmers=new ArrayList<>();


    public OnBoarding_Adapter(Context mContext, ArrayList<OnBoardItem_Farmer> items) {
        this.mContext = mContext;
        this.onBoardItem_farmers = items;
    }

    @Override
    public int getCount() {
        return onBoardItem_farmers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.onboard_item_farmer, container, false);

        OnBoardItem_Farmer item=onBoardItem_farmers.get(position);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_onboard);
        imageView.setImageResource(item.getImageID());

        TextView tv_title=(TextView)itemView.findViewById(R.id.tv_header);
        tv_title.setText(item.getTitle());

        TextView tv_content=(TextView)itemView.findViewById(R.id.tv_desc);
        tv_content.setText(item.getDescription());

        Button btnskip = itemView.findViewById(R.id.btnSkip);
        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CountyList.class);
                mContext.startActivity(intent);
            }
        });

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

}
