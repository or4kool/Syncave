package com.megaworx.syncave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Samuel Oriaku on 8/29/2016.
 */
public class Slider extends AppCompatActivity {


    private int NUM = 3;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pager);
        viewPager = (ViewPager) findViewById(R.id.viewp);
        pagerAdapter = new SliderFrag(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);

    }



    public class SliderFrag extends FragmentStatePagerAdapter{

        Fragment childSliders[] = {new FirstSliderFrag(), new SecondSliderFrag(), new SliderThirdFrag()};


        public SliderFrag(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return childSliders[position];
        }

        @Override
        public int getCount() {
            return NUM;
        }
    }
}
