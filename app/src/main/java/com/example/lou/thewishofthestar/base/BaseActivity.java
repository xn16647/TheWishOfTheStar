package com.example.lou.thewishofthestar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.lou.thewishofthestar.R;

public abstract class  BaseActivity extends AppCompatActivity {

    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.context = this;
        setContentView(getLayout());
        init();
        initLoad();
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
    protected void onStop() {
        super.onStop();
        App.context = null;
    }
}
