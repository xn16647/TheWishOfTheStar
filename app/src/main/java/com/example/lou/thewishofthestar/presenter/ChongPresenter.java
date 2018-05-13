package com.example.lou.thewishofthestar.presenter;

import android.annotation.SuppressLint;

import com.example.lou.thewishofthestar.base.App;
import com.example.lou.thewishofthestar.contract.ChongContract;
import com.example.lou.thewishofthestar.model.bean.MineBean.StarDou;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ChongPresenter implements ChongContract.Presenter{
    private ChongContract.View view;

    public ChongPresenter(ChongContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(String userId) {
        HttpHelp.baseHttpRequest(App.context).create(StarWithService.class).getDou(userId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<StarDou>() {
            @Override
            public void accept(StarDou dou) throws Exception {
                view.showList(dou);
            }
        });
    }
}
