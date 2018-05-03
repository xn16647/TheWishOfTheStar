package com.example.lou.thewishofthestar.utils;

import com.example.lou.thewishofthestar.base.App;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class Retrofit2Utils {

    private static Retrofit2Utils utils;

    private Retrofit2Utils(){
        Retrofit retrofit = new Retrofit.Builder().client(getClient()).baseUrl("").build();
    }


    public static Retrofit2Utils getUtils(){
        return utils;
    }

    private OkHttpClient getClient() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request).newBuilder().removeHeader("Pragma").header("Cache-Control", "max-age=" + 60 * 60 * 24).build();
                return response;
            }
        };
        File file = new File(App.context.getCacheDir(),"cache");
        Cache cache = new Cache(file,1024*1024*30);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(interceptor).cache(cache).build();

        return okHttpClient;
    }
}
