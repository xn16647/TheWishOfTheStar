package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.ProphesyBean;

/**
 * Created by 1
 * on 2018/5/7.
 * at 北京
 */

public interface PropheysContract {
    interface View{
        void showSuccees(ProphesyBean prophesyBean);
        void Error(String e);
    }

    interface Presenter{
        void loadData(Context context,Object page,Object rows,Integer loginUserId,Object startDate,Object endDate);
    }
}
