package com.example.lou.thewishofthestar.contract;

import android.content.Context;

public interface RegisterContract {

    interface View{
        void load();
        void Toast(String e);
        void Success();
        String getCode();
        void isExist();
        String getPhone();
    }

    interface Presenter{
        void getRegisterCode(Context context);
        void loadCode();
        void goRegister();

    }
}
