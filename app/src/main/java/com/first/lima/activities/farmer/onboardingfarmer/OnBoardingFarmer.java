package com.first.lima.activities.farmer.onboardingfarmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.first.lima.R;
import com.first.lima.activities.farmer.CountyList;
import com.first.lima.activities.landowner.LandForm;
import com.first.lima.activities.landowner.onboarding.OnBoardItem;
import com.first.lima.activities.landowner.onboarding.OnBoard_Adapter;
import com.first.lima.activities.landowner.onboarding.OnBoarding;

import java.util.ArrayList;

public class OnBoardingFarmer extends AppCompatActivity {
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;


    private ViewPager onboard_pager;

    private OnBoarding_Adapter mAdapter;

    private Button btnOnBoardFarmer;

    int previous_pos = 0;


    ArrayList<OnBoardItem_Farmer> onBoardItem_farmers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_farmer);

        btnOnBoardFarmer = findViewById(R.id.btnFarmOnBoard);
        onboard_pager = findViewById(R.id.pager_introduction);
        pager_indicator =findViewById(R.id.viewPagerCountDots);

        loadData();
        mAdapter = new OnBoarding_Adapter(this,onBoardItem_farmers);
        onboard_pager.setAdapter(mAdapter);
        onboard_pager.setCurrentItem(0);
        onboard_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // Change the current position intimation

                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(OnBoardingFarmer.this, R.drawable.non_selected_item_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(OnBoardingFarmer.this, R.drawable.selected_item_dot));


                int pos = position + 1;

                if (pos == dotsCount && previous_pos == (dotsCount - 1))
                    show_animation();
                else if (pos == (dotsCount - 1) && previous_pos == dotsCount)
                    hide_animation();

                previous_pos = pos;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnOnBoardFarmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnBoardingFarmer.this, CountyList.class);
                startActivity(intent);
            }
        });

        setUiPageViewController();

    }

    // Load data into the viewpager

    public void loadData() {

        int[] header = {R.string.ob_headerfarm, R.string.ob_header2, R.string.ob_header3};
        int[] desc = {R.string.ob_descfarm, R.string.ob_desc2, R.string.ob_desc3};
        int[] imageId = {R.drawable.iconbig, R.drawable.iconbig, R.drawable.iconbig};

        for (int i = 0; i < imageId.length; i++) {
            OnBoardItem_Farmer item = new OnBoardItem_Farmer();
            item.setImageID(imageId[i]);
            item.setTitle(getResources().getString(header[i]));
            item.setDescription(getResources().getString(desc[i]));

            onBoardItem_farmers.add(item);
        }
    }

    // Button bottomUp animation

    public void show_animation() {
        Animation show = AnimationUtils.loadAnimation(this, R.anim.slide_up_anim);

        btnOnBoardFarmer.startAnimation(show);

        show.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                btnOnBoardFarmer.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                btnOnBoardFarmer.clearAnimation();

            }

        });


    }

    // Button Topdown animation

    public void hide_animation() {
        Animation hide = AnimationUtils.loadAnimation(this, R.anim.slide_down_anim);

        btnOnBoardFarmer.startAnimation(hide);

        hide.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                btnOnBoardFarmer.clearAnimation();
                btnOnBoardFarmer.setVisibility(View.GONE);

            }

        });


    }

    // setup the
    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(OnBoardingFarmer.this, R.drawable.non_selected_item_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(6, 0, 6, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(OnBoardingFarmer.this, R.drawable.selected_item_dot));
    }

}
