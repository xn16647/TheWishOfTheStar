package com.example.lou.thewishofthestar.presenter;

import android.content.Context;
import android.util.Log;

import com.example.lou.thewishofthestar.contract.WokerContract;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 1
 * on 2018/5/4.
 * at 北京
 */

public class WokerPresenter implements WokerContract.Presenter {
    private WokerContract.View view;

    public WokerPresenter(WokerContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData(final Context context) {
        view.showProgress();

        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getWokerData(HttpHelp.getUserId(context), 1, 1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<WokerMasterBean>() {
            @Override
            public void accept(WokerMasterBean wokerMasterBean) throws Exception {
                Log.e("TAG",HttpHelp.getAppToken(context));
                view.showWoker(wokerMasterBean);
                view.hideProgress();
            }
        });
    }
}
