package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;

/**
 * Created by 1
 * on 2018/5/4.
 * at 北京
 */

public interface WokerContract {
    interface View{
        void showWoker(WokerMasterBean wokerMasterBean);
        void Error(String e);
        void showProgress();
        void hideProgress();
    }

    interface Presenter{
        void loadData(Context context);
    }
}
