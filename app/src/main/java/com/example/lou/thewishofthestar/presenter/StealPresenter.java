package com.example.lou.thewishofthestar.presenter;

import android.content.Context;

import com.example.lou.thewishofthestar.contract.RemarkContract;
import com.example.lou.thewishofthestar.contract.StealContract;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 1
 * on 2018/5/6.
 * at 北京
 */

public class StealPresenter implements StealContract.Presenter {
    private StealContract.View view;

    public StealPresenter(StealContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData(Context context) {
        view.showProgress();

        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getStealData(HttpHelp.getUserId(context), 1, 0).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<WokerMasterBean>() {
            @Override
            public void accept(WokerMasterBean wokerMasterBean) throws Exception {
                view.showSteal(wokerMasterBean);
                view.hideProgress();
            }
        });
    }
}
