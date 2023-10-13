package com.android.kotlin_test1.test3

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

//网络接口
interface ApiService {
    companion object {
        public val BASEURL: String by lazy {
            "https://img-blog.csdnimg.cn/"
        }
    }

    @GET("b91c982b140246a28c763ea2bee2fe57.png")
    suspend fun getCSDNImage(): ResponseBody

    //声明为suspend方法
    @GET("image/sogou/api.php")
    suspend fun getImage(@Query("type") type: String = "json"): ImageDataResponseBody

    @GET("b91c982b140246a28c763ea2bee2fe57.png")
    fun getCSDNImageObservable(): Observable<ResponseBody>
}
