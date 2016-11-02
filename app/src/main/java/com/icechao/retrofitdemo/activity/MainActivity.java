package com.icechao.retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.icechao.retrofitdemo.R;
import com.icechao.retrofitdemo.model.ResultBean;
import com.icechao.retrofitdemo.net.ApiService;
import com.icechao.retrofitdemo.net.NetProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * api接口
 *
 * @version V1.0 :<定义接口>
 * @FileName : ApiService
 * @PackageName :com.icechao.retrofitdemo.activity
 * @Author : icechao
 * @Date : 上午11:27
 * @Email :icechliu@gmail.com
 */
public class MainActivity extends AppCompatActivity implements Callback<ResultBean> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIpInfoDefault();
        getIpInfoPack();
    }


    /**
     * 使用retrofit原生请求数据
     */
    private void getIpInfoDefault() {
        String BASE_URL = "http://ip.taobao.com";
        //定义retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                //设置服务器基础url
                .baseUrl(BASE_URL)
                //设置数据转换的方式
                .addConverterFactory(GsonConverterFactory.create())
                //生成Retrofit对象
                .build();
        //用retrofit对象生成一个apiService(定义接口类的对象)对象
        ApiService apiService = retrofit.create(ApiService.class);
        //设置网络请求数据,指定返回的model类
        Call<ResultBean> ipInfo = apiService.getIpInfo("232.176.13.14");
        //执行网络请求
        ipInfo.enqueue(this);



        //取消网络请求
        ipInfo.cancel();
    }

    /**
     * 使用二次封闭的方式请求数据
     */
    private void getIpInfoPack() {
        Call<ResultBean> ipInfo = NetProvider.getSerive().getIpInfo("192.168.1.109");
        //异步请求网络
        ipInfo.enqueue(this);
        ipInfo.cancel();
    }

    /**
     * 异步请求网络成功
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<ResultBean> call, Response<ResultBean> response) {
        Log.e("icechao =>", response.body().toString());
    }

    /**
     * 异步请求网络失败
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<ResultBean> call, Throwable t) {

    }
}
