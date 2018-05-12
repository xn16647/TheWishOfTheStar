package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.DetailsBean;

/**
 * Created by 1
 * on 2018/5/8.
 * at 北京
 */

public interface DetailsContract {
    interface View{
        void showSuccees(DetailsBean detailsBean);
        void Error(String e);
    }

    interface Presenter{
        void loadData(Context context,int loginUserId,int courseId);
    }
}
