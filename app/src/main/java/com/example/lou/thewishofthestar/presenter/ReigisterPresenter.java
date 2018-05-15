package com.example.lou.thewishofthestar.presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.lou.thewishofthestar.base.App;
import com.example.lou.thewishofthestar.contract.MineContract;
import com.example.lou.thewishofthestar.contract.RegisterContract;
import com.example.lou.thewishofthestar.model.AppTokenModel;
import com.example.lou.thewishofthestar.model.bean.MineBean.MineData;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class ReigisterPresenter implements RegisterContract.Presenter {

    RegisterContract.View view;
    private int code;

    public ReigisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    //判断手机号是否注册
    @SuppressLint("CheckResult")
    @Override
    public void getRegisterCode(final Context context) {
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getExist(view.getPhone()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Response<MineData>>() {
                    @Override
                    public void accept(Response<MineData> mineDataResponse) throws Exception {
                        MineData body = mineDataResponse.body();
                        String message = body.getMessage();
                        view.Toast(message);
                        if (body.getCode() == 0) {
                            view.isExist();
                        }
                    }
                });


    }

    //获取验证码
    @SuppressLint("CheckResult")
    @Override
    public void loadCode() {
        HttpHelp.baseHttpRequest(App.context).create(StarWithService.class).getPhoneCode(view.getPhone())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        MineData mineData = new Gson().fromJson(responseBody.string(), MineData.class);
                        if (mineData.getCode() == 0) {
                            view.load();
                        }
                        view.Toast(mineData.getMessage());
                    }
                });

    }

    @SuppressLint("CheckResult")
    @Override
    public void goRegister() {
        HttpHelp.baseHttpRequest(App.context).create(StarWithService.class).goRister(view.getPhone(),view.getCode()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Response<MineData>>() {
            @Override
            public void accept(Response<MineData> mineDataResponse) throws Exception {
                MineData body = mineDataResponse.body();
                int code = body.getCode();
                if(code==0){
                    view.Success();
                }
                view.Toast(body.getMessage());
            }
        });
    }

}