package com.example.lou.thewishofthestar.ui.Fragment.woker.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 1
 * on 2018/5/4.
 * at 北京
 */

public class FraAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragmentList;
    private List<String> title;

    public FraAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> title) {
        super(fm);
        this.fragmentList = fragmentList;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
