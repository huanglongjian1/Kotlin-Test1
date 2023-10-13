package com.android.kotlin_test1.test3

import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

//网络层访问统一入口
object NetworkService {

    //retorfit实例，在这里做一些统一网络配置，如添加转换器、设置超时时间等
    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder()
            .callTimeout(5, TimeUnit.SECONDS).build())
        .baseUrl(ApiService.BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    //网络层访问服务
    val apiService = retrofit.create<ApiService>()

}
