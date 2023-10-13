package com.android.kotlin_test1.test3

import android.accounts.NetworkErrorException
import android.util.MalformedJsonException
import com.android.kotlin_test1.MyAPP
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ExceptionUtil {

    /**
     * 处理异常，toast提示错误信息
     */
    fun catchException(e: Throwable) {
        e.printStackTrace()
        when (e) {
            is HttpException -> {
                catchHttpException(e.code())
                return
            }
            is SocketTimeoutException -> ToastUtil.showShort("R.string.common_error_net_time_out")
            is UnknownHostException, is NetworkErrorException -> ToastUtil.showShort("R.string.common_error_net")
            is MalformedJsonException, is JsonSyntaxException -> ToastUtil.showShort("R.string.common_error_server_json")
            // 接口异常
            is Throwable -> ToastUtil.showShort("$e.errorCode：$e.msg")
            else -> ToastUtil.showShort("----------------")
        }
    }

    /**
     * 处理网络异常
     */
    fun catchHttpException(errorCode: Int) {
        if (errorCode in 200 until 300) return// 成功code则不处理
        ToastUtil.showShort("catchHttpExceptionCode(errorCode)")
    }


    /**
     * 处理网络异常
     */
    private fun catchHttpExceptionCode(errorCode: Int): Int = when (errorCode) {
        in 500..600 -> 500
        in 400 until 500 -> 400
        else -> 300
    }
}
