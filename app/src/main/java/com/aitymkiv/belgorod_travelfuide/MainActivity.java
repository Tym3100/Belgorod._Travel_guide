package com.aitymkiv.belgorod_travelfuide;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.item_feed:
                            mViewPager.setCurrentItem(0);
                            break;
                        case R.id.item_menu:
                            mViewPager.setCurrentItem(1);
                            break;
                        case R.id.item_profile:
                            mViewPager.setCurrentItem(2);
                            break;
                        case R.id.item_purchases:
                            mViewPager.setCurrentItem(3);
                            break;
                    }
                    return true;
                }
            };


    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mBottomNavigationView.getMenu().findItem(R.id.item_feed).setChecked(true);
                    break;
                case 1:
                    mBottomNavigationView.getMenu().findItem(R.id.item_menu).setChecked(true);
                    break;
                case 2:
                    mBottomNavigationView.getMenu().findItem(R.id.item_profile).setChecked(true);
                    break;
                case 3:
                    mBottomNavigationView.getMenu().findItem(R.id.item_purchases).setChecked(true);
                    break;
            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        MyViewPagerAdapter mMyViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mBottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        mViewPager.addOnPageChangeListener(onPageChangeListener);
        mViewPager.setAdapter(mMyViewPagerAdapter);
    }
}