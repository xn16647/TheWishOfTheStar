package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;

public interface LoginContract {
    interface View{
        void showSuccees(int id);
        void Message(String e);
        String getPhone();
        String getPsw();
    }

    interface Presenter{
        void loadData(Context context);
    }
}
