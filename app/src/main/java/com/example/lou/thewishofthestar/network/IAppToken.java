package com.example.lou.thewishofthestar.network;


import com.example.lou.thewishofthestar.model.AppTokenModel;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by vicoltree on 17/12/12.
 */

public interface IAppToken {

    @POST
    Observable<AppTokenModel> getAppToken(@Url String url);
}
