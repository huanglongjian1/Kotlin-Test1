package com.android.kotlin_test1.test4.retrofit

import com.android.kotlin_test1.MyAPP
import com.android.kotlin_test1.test2.db.AppDatabase
import com.android.kotlin_test1.test4.bean.JavaBean
import com.android.kotlin_test1.base.retrofit.RetrofitBuilder.apiService
import com.android.kotlin_test1.util.Loge

class MainRepository() {
    suspend fun getListUsers() = apiService.getListUsers()
    fun getUsersObservable() = apiService.getUsersObservable()
    suspend fun getUsersFromNetAndRoom(): List<JavaBean> {
        var javaBeans = AppDatabase.getInstance(MyAPP.getApplication()).javaBeanDao().listJavaBean
        if (javaBeans.size > 0) {
            Loge.e("数据来自本地Room数据库")
            return javaBeans
        } else {
            Loge.e("数据来自网络")
            javaBeans = apiService.getListUsers()
            AppDatabase.getInstance(MyAPP.getApplication()).javaBeanDao().insertAll(javaBeans)
            return javaBeans
        }
    }
}
