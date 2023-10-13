package com.android.kotlin_test1.test5.bean

import java.io.File

/**
 * 下载状态
 * Created by aruba on 2021/9/19.
 */
sealed class DownloadStatus {
    data class Progress(val progress: Int) : DownloadStatus()
    data class Err(val t: Throwable) : DownloadStatus()
    data class Done(val file: File) : DownloadStatus()
    data class Msg(val message: String) : DownloadStatus()
}