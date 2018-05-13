package com.example.lou.thewishofthestar.presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.lou.thewishofthestar.base.App;
import com.example.lou.thewishofthestar.contract.MineContract;
import com.example.lou.thewishofthestar.model.bean.MineBean.DataBeanX;
import com.example.lou.thewishofthestar.model.bean.MineBean.MineData;
import com.example.lou.thewishofthestar.model.bean.MineBean.UserInfo;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MinePresenter implements MineContract.Presenter{

    private MineContract.View view;

    public MinePresenter(MineContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getUserInfo(int id) {
        HttpHelp.baseHttpRequest(App.context).create(StarWithService.class).getUserInfo(id+"").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<UserInfo>() {
            @Override
            public void accept(UserInfo userInfo) throws Exception {
                DataBeanX data = userInfo.getData();

                view.showSuccess(userInfo);
            }
    });

    }

    @SuppressLint("CheckResult")
    @Override
    public void loadRegister(String Code) {
        HttpHelp.baseHttpRequest(App.context).create(StarWithService.class).getUserInfo(Code).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<UserInfo>() {
            @Override
            public void accept(UserInfo userInfo) throws Exception {
            }
        });
    }
}
