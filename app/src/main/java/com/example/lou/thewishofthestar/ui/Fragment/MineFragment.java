package com.example.lou.thewishofthestar.ui.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;
import com.example.lou.thewishofthestar.ui.Activity.MainActivity;

public class MineFragment extends BaseFragment{

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void initLoad() {

    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            ((MainActivity)getActivity()).title_liner.setVisibility(View.VISIBLE);
            ((MainActivity)getActivity()).myselt_head.setVisibility(View.GONE);
        }else {
            ((MainActivity)getActivity()).title_liner.setVisibility(View.GONE);
            ((MainActivity)getActivity()).myselt_head.setVisibility(View.VISIBLE);
        }
    }
}
