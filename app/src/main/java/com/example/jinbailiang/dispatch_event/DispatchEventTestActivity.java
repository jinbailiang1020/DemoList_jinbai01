package com.example.jinbailiang.dispatch_event;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.jinbailiang.demos_jinbai.R;

public class DispatchEventTestActivity extends FragmentActivity {

    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch_event_test);
        initView();
        setViewpager();
                
    }
    private void initView() {
        view_pager = (ViewPager)findViewById(R.id.view_pager);
    }

    private void setViewpager() {
        final Fragment[]fragmentArray = new Fragment[]{new DispatchEventTestFragment(),new DispatchEventTestFragment02()};
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentArray[position];
            }

            @Override
            public int getCount() {
                return fragmentArray.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return super.isViewFromObject(view, object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                return super.instantiateItem(container, position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                super.destroyItem(container, position, object);
            }

            @Override
            public void startUpdate(ViewGroup container) {
                super.startUpdate(container);
            }
        };
        view_pager.setAdapter(adapter);
        view_pager.setCurrentItem(0);
    }



}
