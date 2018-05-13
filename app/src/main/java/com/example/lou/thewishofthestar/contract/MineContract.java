package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.MineBean.UserInfo;

public interface MineContract {
    interface View{
        void showSuccess(UserInfo message);
        void Message(String e);
        void showLogined();
        void showUnLogin();
    }

    interface Presenter{
        void getUserInfo(int id );
        void loadRegister(String Code);

    }
}
