package com.android.kotlin_test1.test3.one

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.kotlin_test1.base.BaseViewModel

class CusViewModel(application: Application) :BaseViewModel(application) {
    /**
     * 一个可被观察的数据类，并且能感知View（Activity等）生命周期
     * databinding后view的输入，或者数据的改变均会通知到双方
     */
    val loginInfoData = MutableLiveData<LoginInfo>()

    init {
        // 初始化loginInfo对象
        loginInfoData.value = LoginInfo()
    }

    fun login() {
        // 模拟登录，正常场景应通过model层进行网络请求等
        val loginInfo = loginInfoData.value
        if (loginInfo != null) {
            if ("123" == loginInfo.name && "123" == loginInfo.pwd) {
                loginInfo.state = "成功"
            } else {
                loginInfo.state = "失败"
            }
        }
    }
}