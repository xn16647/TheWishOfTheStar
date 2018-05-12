package com.example.lou.thewishofthestar.network;

import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.DetailsBean;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.ProphesyBean;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.JobPartBean;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StarWithService {
    @FormUrlEncoded
    @POST("/v1/m/home/list")
    Observable<HomeBean> getHomeData(@Field("loginUserID") Integer id);

    @FormUrlEncoded
    @POST("/v1/m/homewok/home")
    Observable<WokerMasterBean> getWokerData(@Field("loginUserId")Integer loginUserId,@Field("page")Integer page,@Field("sortord")Integer sortord);

    @FormUrlEncoded
    @POST("/v1/m/homewok/home")
    Observable<WokerMasterBean> getRemarkData(@Field("loginUserId")Integer loginUserId,@Field("page")Integer page,@Field("sortord")Integer sortord);

    @FormUrlEncoded
    @POST("/v1/m/homewok/home")
    Observable<WokerMasterBean> getStealData(@Field("loginUserId")Integer loginUserId,@Field("page")Integer page,@Field("sortord")Integer sortord);


    @FormUrlEncoded
    @POST("/v1/m/artcircle/home")
    Observable<BookMasterBean> getBookData(@Field("loginUserId")Integer loginUserId, @Field("rows")Integer rows, @Field("sortord")Integer sortord);

    @FormUrlEncoded
    @POST("/v1/m/forthcoming/home")
    Observable<ProphesyBean> getPropheysData(@Field("page")Object page,@Field("rows")Object rows,@Field("loginUserId")Integer loginUserId, @Field("startDate")Object startDate, @Field("endDate")Object endDate);

    @FormUrlEncoded
    @POST("/v1/m/forthcoming/detail")
    Observable<DetailsBean> getDetailsData(@Field("loginUserId")Integer loginUserId, @Field("courseId")Integer courseId);

    @FormUrlEncoded
    @POST("/v1/m/homewok/detail")
    Observable<JobPartBean> getJobPartData(@Field("loginUserId")Integer loginUserId, @Field("homewokId")Integer homewokId);
}
