package com.android.kotlin_test1.test5.util

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.android.kotlin_test1.R

object DialogUtil {
    /**
     * 下载进度条弹窗
     */
    fun showDownloadProgress(
        context: Context,
        title: String? = null
    ): AlertDialog = context.let {
        AlertDialog.Builder(it).create().apply {
            // 设置点击dialog的外部能否取消弹窗
            setCanceledOnTouchOutside(false)
            // 设置能不能返回键取消弹窗
            setCancelable(false)
            show()
            window?.run {
                setLayout(
                    600,
                    200
                )
            }
            setContentView(
                View.inflate(it, R.layout.alert_dialog_download_progress, null).apply {
                    // 设置成顶层视图
                    bringToFront()
                    title?.let { text ->
                        findViewById<TextView>(R.id.d_title).text = text
                    }
                }
            )
        }
    }


}