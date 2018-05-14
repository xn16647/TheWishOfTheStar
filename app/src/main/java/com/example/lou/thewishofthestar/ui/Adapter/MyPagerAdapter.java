package com.example.lou.thewishofthestar.ui.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter{

    private List<String> mList;
    private List<Fragment> mFragments;
    public MyPagerAdapter(FragmentManager fm, List<String>mList,List<Fragment> mFragments) {
        super(fm);
        this.mList = mList;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
