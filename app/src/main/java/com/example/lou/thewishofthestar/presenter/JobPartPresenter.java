package com.example.lou.thewishofthestar.presenter;

import android.content.Context;

import com.example.lou.thewishofthestar.contract.JobPartContract;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.JobPartBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 1
 * on 2018/5/11.
 * at 北京
 */

public class JobPartPresenter implements JobPartContract.Presenter{
    private JobPartContract.View view;
    public JobPartPresenter(JobPartContract.View view) {
        this.view=view;
    }

    @Override
    public void loadData(Context context,Integer homewokId) {
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getJobPartData(HttpHelp.getUserId(context),homewokId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<JobPartBean>() {
            @Override
            public void accept(JobPartBean jobPartBean) throws Exception {
                if(jobPartBean.getMessage().equals("成功")){
                    view.showWoker(jobPartBean);
                }else{
                    view.Error("请求失败");
                }
            }
        });
    }
}
