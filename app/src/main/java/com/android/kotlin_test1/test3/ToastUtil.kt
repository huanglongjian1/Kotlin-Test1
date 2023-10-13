package com.android.kotlin_test1.test3

import com.android.kotlin_test1.util.Loge

object ToastUtil {
    fun showShort(string: String) {
        Loge.e(string)
    }
}