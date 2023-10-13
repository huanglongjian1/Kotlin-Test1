package com.android.kotlin_test1.test5

import com.android.kotlin_test1.test5.bean.DownloadStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.InputStream
import java.io.OutputStream

/**
 * Created by aruba on 2021/9/19.
 */
object DownloadManager {
    fun download(url: String, file: File): Flow<DownloadStatus> {
        return flow {
            val request = Request.Builder().url(url).get().build()
            val response = OkHttpClient.Builder().build()
                .newCall(request).execute()
            if (response.isSuccessful) {
                response.body!!.let { body ->
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
                                    emit(DownloadStatus.Progress(progress.toInt()))
                                    emittedProcess = progress
                                }
                            }
                        }
                    }
                    //下载完成
                    emit(DownloadStatus.Done(file))
                }
            } else {
                throw Exception(response.message)
            }
        }.catch {

            file.delete()
            emit(DownloadStatus.Err(it))
            //保留最新的值
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