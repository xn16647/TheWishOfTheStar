package com.example.lou.thewishofthestar.contract;

import android.content.Context;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;

import java.util.HashMap;

public interface SupplementContract {
    interface View{
        void showSuccees();
        void Message(String e);
    }

    interface Presenter{
        void loadData(Context context, HashMap<String,String> params);
    }
}
