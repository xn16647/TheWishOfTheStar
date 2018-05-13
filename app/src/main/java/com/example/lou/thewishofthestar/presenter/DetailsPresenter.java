package com.example.lou.thewishofthestar.presenter;

import android.content.Context;

import com.example.lou.thewishofthestar.contract.DetailsContract;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.DetailsBean;
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

public class DetailsPresenter implements DetailsContract.Presenter{
   private DetailsContract.View view;
    public DetailsPresenter(DetailsContract.View view) {
        this.view=view;
    }

    @Override
    public void loadData(Context context, int loginUserId, int courseId) {
        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getDetailsData(loginUserId,courseId).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<DetailsBean>() {
            @Override
            public void accept(DetailsBean detailsBean) throws Exception {
                if(detailsBean.getMessage().equals("成功")){
                    view.showSuccees(detailsBean);
                }else{
                    view.Error("失败");
                }
            }
        });
    }
}
