package com.aitymkiv.belgorod_travelfuide;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    public MyViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Log.d("MyTag", "You are in getItem 0");
                return new FeedFragment();
            case 1:
                Log.d("MyTag", "You are in getItem 1");
                return new MenuFragment();
            case 2:
                Log.d("MyTag", "You are in getItem 2");
                return new ProfileFragment();
            case 3:
                Log.d("MyTag", "You are in getItem 3");
                return new MarketFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
