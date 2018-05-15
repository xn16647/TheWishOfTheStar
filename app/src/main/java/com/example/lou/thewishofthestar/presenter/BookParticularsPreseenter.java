package com.example.lou.thewishofthestar.presenter;

import android.content.Context;

import com.example.lou.thewishofthestar.contract.BookParticularsContract;
import com.example.lou.thewishofthestar.model.bean.BookEntity.ParticularsBookBean;
import com.example.lou.thewishofthestar.network.StarWithService;
import com.example.lou.thewishofthestar.utils.HttpHelp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 1
 * on 2018/5/15.
 * at 北京
 */

public class BookParticularsPreseenter implements BookParticularsContract.Presenter {
    private BookParticularsContract.View view;
    public BookParticularsPreseenter(BookParticularsContract.View view) {
        this.view=view;
    }

    @Override
    public void loadData(Context context, int loginUserId, int courseId) {
        HttpHelp.baseHttpRequest(context)
                .create(StarWithService.class)
                .getParticularsBookData(courseId,loginUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ParticularsBookBean>() {
            @Override
            public void accept(ParticularsBookBean particularsBookBean) throws Exception {
                view.showSuccees(particularsBookBean);
            }
        });
    }
}
