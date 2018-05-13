package com.example.lou.thewishofthestar.presenter;

import android.content.Context;

import com.example.lou.thewishofthestar.contract.PropheysContract;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.ProphesyBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 1
 * on 2018/5/8.
 * at 北京
 */

public class PropheysPresenter implements PropheysContract.Presenter {
    private PropheysContract.View view;
    public PropheysPresenter( PropheysContract.View view) {
        this.view=view;
    }


    @Override
    public void loadData(Context context, Object page, Object rows, Integer loginUserId, Object startDate, Object endDate) {
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getPropheysData(page,rows,loginUserId,startDate,endDate).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ProphesyBean>() {
            @Override
            public void accept(ProphesyBean prophesyBean) throws Exception {
                view.showSuccees(prophesyBean);
            }
        });
    }

}
