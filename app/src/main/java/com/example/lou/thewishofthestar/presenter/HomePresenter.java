package com.example.lou.thewishofthestar.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.example.lou.thewishofthestar.contract.HomeContract;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter{
    HomeContract.View view;
    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(final Context context) {
        view.showProgress();
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getHomeData(HttpHelp.getUserId(context)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<HomeBean>() {
            @Override
            public void accept(HomeBean homeBean) throws Exception {
                String message = homeBean.getMessage();
                view.showSuccees(homeBean);
                view.hideProgress();
            }
        });
    }
}
