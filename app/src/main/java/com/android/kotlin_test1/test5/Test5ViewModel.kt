package com.android.kotlin_test1.test5

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.kotlin_test1.base.BaseViewModel
import com.android.kotlin_test1.base.retrofit.RetrofitBuilder
import com.android.kotlin_test1.test5.bean.DownloadStatus
import com.android.kotlin_test1.util.Loge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.File


class Test5ViewModel(val context: Application) : BaseViewModel(context) {
    private var progressData = MutableLiveData<Int>()
    val progress = progressData

    private val url: String = "https://downv6.qq.com/qqweb/QQ_1/android_apk/Android_8.9.83_64.apk"

    fun downloadClick(v: View) {
        viewModelScope.launch {
            progressData.value = 0
            val file = File(context.getExternalFilesDir(null), "test.rar")
            DownloadManager.download(url, file).collect {
                when (it) {
                    is DownloadStatus.Progress -> {
                        Log.i("progress", "progress: $it.progress")
                        progressData.value = it.progress
                    }
                    is DownloadStatus.Done -> {
                        progressData.value = 100
                        Toast.makeText(context, "下载完成", Toast.LENGTH_SHORT).show()
                    }
                    is DownloadStatus.Err -> {
                        Loge.e(it.toString())
                        Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
                    }
                    is DownloadStatus.Msg -> {
                        Loge.e(it.message)
                    }
                }
            }
        }
    }


    fun downLoadBaidu() {
        viewModelScope.launch {
            DownloadManager_kt.download2().collect {
                when (it) {
                    is DownloadStatus.Msg -> {
                        Loge.e(it.message)
                    }
                    else -> {}
                }
            }
        }

    }

    fun returnString() {
        viewModelScope.launch(Dispatchers.Main) {
            onConfirmListner?.invoke(RetrofitBuilder.downloadApi2.getBaidu().string())

        }

        onCancelListener?.invoke()
    }

    var onConfirmListner: ((string: String) -> Unit)? = null
    var onCancelListener: (() -> Unit)? = null

    fun setOnDialogListener(
        onConfirmListner: ((string: String) -> Unit),
        onCancelListener: (() -> Unit)? = null
    ) {
        this.onConfirmListner = onConfirmListner
        this.onCancelListener = onCancelListener
    }

}