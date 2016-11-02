package com.icechao.retrofitdemo.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit 封装
 *
 * @version V1.0 :<提供retrofit对象>
 * @FileName : NetProvider
 * @PackageName :com.icechao.retrofitdemo.net
 * @Author : icechao
 * @Date : 上午11:27
 * @Email :icechliu@gmail.com
 */
public class NetProvider {

    private static final String BASE_URL = "http://ip.taobao.com";

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static Retrofit retrofit;

    public static ApiService getSerive() {
        return retrofit.create(ApiService.class);
    }

}
