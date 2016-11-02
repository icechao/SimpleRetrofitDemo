package com.icechao.retrofitdemo.net;

import com.icechao.retrofitdemo.model.ResultBean;

import java.io.File;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * api接口
 *
 * @version V1.0 :<定义接口>
 * @FileName : ApiService
 * @PackageName :com.icechao.retrofitdemo.net
 * @Author : icechao
 * @Date : 上午11:27
 * @Email :icechliu@gmail.com
 */
public interface ApiService {

//    http://ip.taobao.com/service/getIpInfo.php?ip=197.244.11.11

    @GET("service/getIpInfo.php")
    Call<ResultBean> getIpInfo(@Query("ip") String ip);


    /**
     * 图片上传
     * @param des 文件名
     * @param file 文件
     * @return
     */
    @Multipart
    @POST("/fileabout.php")
    Call<String> upload(@Part("fileName") String des, @Part("file\"; filename=\"1.txt") RequestBody file);
}

