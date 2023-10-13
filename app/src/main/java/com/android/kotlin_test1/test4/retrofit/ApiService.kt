package com.android.kotlin_test1.test4.retrofit

import com.android.kotlin_test1.test4.bean.JavaBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<JavaBean>>

    @GET("users")
    suspend fun getListUsers(): List<JavaBean>

    @GET("users")
    fun getUsersObservable(): Observable<List<JavaBean>>

}
