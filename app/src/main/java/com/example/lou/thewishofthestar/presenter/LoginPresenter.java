package com.example.lou.thewishofthestar.presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import com.example.lou.thewishofthestar.contract.LoginContract;
import com.example.lou.thewishofthestar.model.bean.MineBean.DataBean;
import com.example.lou.thewishofthestar.model.bean.MineBean.MineData;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.Presenter{

    LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadData(Context context) {
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).goLogin(view.getPhone(),view.getPsw()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Response<MineData>>() {
            @Override
            public void accept(Response<MineData> mineDataResponse) throws Exception {
                MineData body = mineDataResponse.body();
                DataBean data = body.getData();
                if (data!=null) {
                    view.Message("登陆成功！");
                    view.showSuccees(data.getId());
                }else {
                    view.Message(body.getMessage());
                }

            }
        });
    }
}
