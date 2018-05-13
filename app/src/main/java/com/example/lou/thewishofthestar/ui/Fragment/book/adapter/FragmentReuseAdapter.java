package com.example.lou.thewishofthestar.ui.Fragment.book.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 1
 * on 2018/5/7.
 * at 北京
 */

public class FragmentReuseAdapter extends FragmentPagerAdapter {
    private List<String> title;
    private List<Fragment>fragmentList;

    public FragmentReuseAdapter(FragmentManager fm, List<String> title, List<Fragment> fragmentList) {
        super(fm);
        this.title = title;
        this.fragmentList = fragmentList;
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
