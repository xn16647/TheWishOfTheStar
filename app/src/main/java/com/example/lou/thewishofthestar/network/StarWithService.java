package com.example.lou.thewishofthestar.network;

import com.example.lou.thewishofthestar.model.bean.BookEntity.BookMasterBean;
import com.example.lou.thewishofthestar.model.bean.HomeEntity.HomeBean;
import com.example.lou.thewishofthestar.model.bean.MineBean.MineData;
import com.example.lou.thewishofthestar.model.bean.MineBean.StarDou;
import com.example.lou.thewishofthestar.model.bean.MineBean.UserInfo;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.DetailsBean;
import com.example.lou.thewishofthestar.model.bean.ProphesyEntity.ProphesyBean;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.JobPartBean;
import com.example.lou.thewishofthestar.model.bean.WokerMasterEntity.WokerMasterBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface StarWithService {
    /**
     * 首页模版
     *
     * @param id
     * @return
     */
    //首页
    @FormUrlEncoded
    @POST("/v1/m/home/list")
    Observable<HomeBean> getHomeData(@Field("loginUserID") Integer id);

    /**
     *我的模块
     */

    //获取短信验证码
    @FormUrlEncoded
    @POST("/v1/m/user/authcode")
    Observable<ResponseBody> getPhoneCode(@Field("mobile") String phoneNumber);

    //注册账号
    @FormUrlEncoded
    @POST("/v1/m/user/register/mobile")
    Observable<Response<MineData>> goRister(@Field("mobile") String mobileNumber, @Field("mobileValidCode") String mobileCode);

    //完善用户信息
    @FormUrlEncoded
    @POST("/v1/m/user/saveCompleteUser")
    Observable<Response<MineData>> goInformation(@FieldMap HashMap<String, String> mParams);

    //验证手机号是否存在
    @FormUrlEncoded
    @POST("/v1/m/user/verify/mobile")
    Observable<Response<MineData>> getExist(@Field("mobile") String phoneNumber);

    //登陆
    @FormUrlEncoded
    @POST("/v1/m/user/login/mobile")
    Observable<Response<MineData>> goLogin(@Field("mobile") String mobileNumber, @Field("password") String psw);

    //获取用户信息
    @FormUrlEncoded
    @POST("/v1/m/user/info")
    Observable<UserInfo> getUserInfo(@Field("loginUserId")String id);

    //星豆充值列表
    @FormUrlEncoded
    @POST("/v1/m/record/bean/detail")
    Observable<StarDou> getDou(@Field("loginUserId")String id);


    @FormUrlEncoded
    @POST("/v1/m/homewok/home")
    Observable<WokerMasterBean> getWokerData(@Field("loginUserId")Integer loginUserId, @Field("page")Integer page, @Field("sortord")Integer sortord);

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
    Observable<ProphesyBean> getPropheysData(@Field("page")Object page, @Field("rows")Object rows, @Field("loginUserId")Integer loginUserId, @Field("startDate")Object startDate, @Field("endDate")Object endDate);

    @FormUrlEncoded
    @POST("/v1/m/forthcoming/detail")
    Observable<DetailsBean> getDetailsData(@Field("loginUserId")Integer loginUserId, @Field("courseId")Integer courseId);

    @FormUrlEncoded
    @POST("/v1/m/homewok/detail")
    Observable<JobPartBean> getJobPartData(@Field("loginUserId")Integer loginUserId, @Field("homewokId")Integer homewokId);



}
