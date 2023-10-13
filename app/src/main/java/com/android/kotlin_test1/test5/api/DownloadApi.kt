package com.android.kotlin_test1.test5.api

import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface DownloadApi {
    companion object {
        val BASEURL by lazy {
            "https://downv6.qq.com/qqweb/QQ_1/"
        }
        val BASEURL2 by lazy {
            "https://www.baidu.com/"
        }
    }


    @GET("android_apk/Android_8.9.83_64.apk")
    fun downloadAPK(): Observable<ResponseBody>

    @GET("/")
    suspend fun getBaidu(): ResponseBody

    @GET("/")
    fun getBaidu2(): Call<ResponseBody>
}