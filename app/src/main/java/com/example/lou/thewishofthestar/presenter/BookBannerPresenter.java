package com.example.lou.thewishofthestar.presenter;

import android.content.Context;

import com.example.lou.thewishofthestar.contract.ValueBleBookContract;
import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 1
 * on 2018/5/7.
 * at 北京
 */

public class BookBannerPresenter implements ValueBleBookContract.Presenter {
   private ValueBleBookContract.View view;
    public BookBannerPresenter(ValueBleBookContract.View view) {
        this.view=view;
    }

    @Override
    public void loadData(final Context context,int rows,int sortord) {

        HttpHelp.baseHttpRequest(context).create(StarWithService.class).getBookData(HttpHelp.getUserId(context),rows,sortord).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<BookMasterBean>() {
            @Override
            public void accept(BookMasterBean bookMasterBean) throws Exception {
                String message = bookMasterBean.getMessage();
                if ("成功".equals(message)) {
                    view.showBookdata(bookMasterBean);
                } else {
                    view.Error("数据请求失败");
                }
            }
        });
    }
}
