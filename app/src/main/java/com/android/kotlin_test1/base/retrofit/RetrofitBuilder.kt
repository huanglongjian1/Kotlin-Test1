package com.android.kotlin_test1.base.retrofit

import com.android.kotlin_test1.test4.retrofit.ApiService
import com.android.kotlin_test1.test5.api.DownloadApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {
    val httpBuilder: OkHttpClient.Builder
        get() {
            // create http client
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor { chain ->
                    val original = chain.request()

                    //header
                    val request = original.newBuilder()
                        .method(original.method, original.body)
                        .build()

                    return@Interceptor chain.proceed(request)
                })
                .readTimeout(30, TimeUnit.SECONDS)

            // log interceptor
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClient.addInterceptor(loggingInterceptor)

            return httpClient
        }

    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    private fun getRetrofit(BASEURL: String): Retrofit {
        return Retrofit.Builder()
            .client(httpBuilder.build())
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: ApiService = getRetrofit(BASE_URL).create(ApiService::class.java)
    val downloadApi: DownloadApi = getRetrofit("https://downv6.qq.com/qqweb/QQ_1/").create(DownloadApi::class.java)
    val downloadApi2: DownloadApi = getRetrofit(DownloadApi.BASEURL2).create(DownloadApi::class.java)
}
