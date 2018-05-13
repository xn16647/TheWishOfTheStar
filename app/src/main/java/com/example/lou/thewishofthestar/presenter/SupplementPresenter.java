package com.example.lou.thewishofthestar.presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.lou.thewishofthestar.contract.SupplementContract;
import com.example.lou.thewishofthestar.model.bean.MineBean.MineData;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SupplementPresenter implements SupplementContract.Presenter{

    private SupplementContract.View view;

    public SupplementPresenter(SupplementContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(Context context,HashMap<String,String> params) {
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).goInformation(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Response<MineData>>() {
            @Override
            public void accept(Response<MineData> mineDataResponse) throws Exception {
                MineData body = mineDataResponse.body();
                int code = body.getCode();
                if(code==0){
                    view.showSuccees();
                }
                view.Message(body.getMessage());
            }
        });
    }
}
