package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;

/**
 * Created by 1
 * on 2018/5/6.
 * at 北京
 */

public interface StealContract {
    interface View{
        void showSteal(WokerMasterBean wokerMasterBean);
        void Error(String e);
        void showProgress();
        void hideProgress();
    }

    interface Presenter{
        void loadData(Context context);
    }
}
