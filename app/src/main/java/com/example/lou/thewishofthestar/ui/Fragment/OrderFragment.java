package com.example.lou.thewishofthestar.ui.Fragment;

import android.os.Handler;
import android.view.View;

import com.example.lou.thewishofthestar.R;
import com.example.lou.thewishofthestar.base.BaseFragment;


public class OrderFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.order_fragment_layout;
    }

    @Override
    protected void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().findViewById(R.id.imageView3).setVisibility(View.VISIBLE);
                getView().findViewById(R.id.textView4).setVisibility(View.VISIBLE);
            }
        },500);
    }

    @Override
    protected void initLoad() {

    }
}
