package com.example.lou.thewishofthestar.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.lou.thewishofthestar.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import butterknife.ButterKnife;

public abstract class  BaseActivity extends AppCompatActivity {

    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayout());
        ButterKnife.bind(this);
        init();
        initLoad();
       // getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }



    protected abstract int getLayout();

    protected abstract void init();

    protected abstract void initLoad();

    public void setContentView(Class<? extends BaseFragment> fragmentClass){
        //获取fragment管理器
        FragmentManager manager = getSupportFragmentManager();
        //获取操作fragment的容器
        FragmentTransaction transaction = manager.beginTransaction();

        String simpleName = fragmentClass.getSimpleName();
        BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(simpleName);

        if(fragment==null){
            try {
                fragment = fragmentClass.newInstance();
                transaction.add(R.id.home_frame,fragment,simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }

        if(lastFragment!=null){
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);

        lastFragment = fragment;

        transaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.context = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
    }
}
