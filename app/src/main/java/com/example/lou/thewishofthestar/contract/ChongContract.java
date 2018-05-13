package com.example.lou.thewishofthestar.contract;

import com.example.lou.thewishofthestar.model.bean.MineBean.StarDou;

public interface ChongContract {
    interface View{
        void showList(StarDou dou);
    }

    interface Presenter{
        void loadData(String userId);
    }

}
