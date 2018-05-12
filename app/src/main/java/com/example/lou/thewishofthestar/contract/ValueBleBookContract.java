package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;

/**
 * Created by 1
 * on 2018/5/7.
 * at 北京
 */

public interface ValueBleBookContract {
    interface View{
        void Error(String e);
        void showBookdata(BookMasterBean bookMasterBean);
    }

    interface Presenter{
        void loadData(Context context,int rows,int sortord);
    }
}
