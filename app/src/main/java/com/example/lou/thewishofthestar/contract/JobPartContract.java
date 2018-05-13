package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.JobPartBean;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;

/**
 * Created by 1
 * on 2018/5/11.
 * at 北京
 */

public interface JobPartContract {
    interface View{
        void showWoker(JobPartBean jobPartBean);
        void Error(String e);
    }

    interface Presenter{
        void loadData(Context context,Integer homewokId);
    }
}
