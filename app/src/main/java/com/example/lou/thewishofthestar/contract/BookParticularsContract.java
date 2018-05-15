package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.BookEntity.ParticularsBookBean;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.DetailsBean;

/**
 * Created by 1
 * on 2018/5/15.
 * at 北京
 */

public interface BookParticularsContract {
    interface View{
        void showSuccees(ParticularsBookBean particularsBookBean);
        void Error(String e);
    }

    interface Presenter{
        void loadData(Context context, int loginUserId, int courseId);
    }
}
