package com.example.lou.thewishofthestar.network;

import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StarWithService {
    @FormUrlEncoded
    @POST("/v1/m/home/list")
    Observable<HomeBean> getHomeData(@Field("loginUserID") Integer id);
}
