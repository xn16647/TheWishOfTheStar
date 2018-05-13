package com.example.lou.thewishofthestar.ui.Fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.androidkun.xtablayout.XTabLayout;
import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.contract.WokerContract;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;
import com.example.lou.thewishofthestar.presenter.WokerPresenter;
import com.example.lou.thewishofthestar.ui.Fragment.woker.NoopsycheFragment;
import com.example.lou.thewishofthestar.ui.Fragment.woker.RemarkFragment;
import com.example.lou.thewishofthestar.ui.Fragment.woker.StealFragment;
import com.example.lou.thewishofthestar.ui.Fragment.woker.adapter.FraAdapter;

import java.util.ArrayList;
import java.util.List;

public class WokerFragment extends BaseFragment {
    private ViewPager vp;
    private XTabLayout tablay;
    private List<Fragment> fragmentList;
    private List<String> title;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_woker;
    }

    @Override
    protected void init() {
        vp = getView().findViewById(R.id.vp);
        tablay = getView().findViewById(R.id.tablay);

    }

    @Override
    protected void initLoad() {
        fragmentList = new ArrayList<>();
        title = new ArrayList<>();
        title.add("智能筛选");
        title.add("偷听最多");
        title.add("最新点评");
        fragmentList.add(new NoopsycheFragment());
        StealFragment stealFragment = new StealFragment();
        fragmentList.add(stealFragment);
        fragmentList.add(new RemarkFragment());
        FraAdapter fraAdapter = new FraAdapter(getChildFragmentManager(), fragmentList, title);
        vp.setAdapter(fraAdapter);
        tablay.setupWithViewPager(vp);

    }

}
