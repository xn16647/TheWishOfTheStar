package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;

public interface HomeContract {
    interface View{
        void showSuccees(HomeBean homeBean);
        void Error(String e);
        void showProgress();
        void hideProgress();
    }

    interface Presenter{
        void loadData(Context context);
    }
}
