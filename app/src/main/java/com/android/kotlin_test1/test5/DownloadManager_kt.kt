package com.android.kotlin_test1.test5

import androidx.lifecycle.MutableLiveData
import com.android.kotlin_test1.MyAPP
import com.android.kotlin_test1.base.retrofit.RetrofitBuilder.downloadApi
import com.android.kotlin_test1.base.retrofit.RetrofitBuilder.downloadApi2
import com.android.kotlin_test1.test5.bean.DownloadStatus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File
import java.io.InputStream
import java.io.OutputStream

object DownloadManager_kt {
    public val mutableLiveData: MutableLiveData<DownloadStatus> = MutableLiveData()
    fun download() {
        val file = File(
            MyAPP.getApplication().getExternalFilesDir("download_02"),
            "${System.currentTimeMillis()}_qq.apk"
        )
        downloadApi.downloadAPK().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { body ->
                //总大小
                val total = body.contentLength()
                //当前值
                var emittedProcess = 0L
                file.outputStream().use { output ->
                    body.byteStream().use { input ->
                        input.copyTo(output) { bytesCopied ->
                            //计算百分比
                            val progress = bytesCopied * 100 / total
                            //当前的值大于上一次的就进行通知
                            if (progress - emittedProcess > 1) {
                                //发射，外部的 collect 会执行
                                mutableLiveData.postValue(DownloadStatus.Progress(progress.toInt()))
                                emittedProcess = progress
                            }
                        }
                    }
                }
                //下载完成
                mutableLiveData.postValue(DownloadStatus.Done(file))
            }
    }

    fun download2(): Flow<DownloadStatus> {
        return flow {
            emit(DownloadStatus.Msg("开始访问"))
            val html = downloadApi2.getBaidu().string()
            emit(DownloadStatus.Msg(html))
        }.flowOn(Dispatchers.IO)
    }

    //重写了一些copyTo 方法，增加了一个参数，用来回调下载进度
    inline fun InputStream.copyTo(
        out: OutputStream,
        bufferSize: Int = DEFAULT_BUFFER_SIZE,
        progress: (Long) -> Unit
    ): Long {
        var bytesCopied: Long = 0
        val buffer = ByteArray(bufferSize)
        var bytes = read(buffer)
        while (bytes >= 0) {
            out.write(buffer, 0, bytes)
            bytesCopied += bytes
            bytes = read(buffer)

            progress(bytesCopied)
        }
        return bytesCopied
    }
}