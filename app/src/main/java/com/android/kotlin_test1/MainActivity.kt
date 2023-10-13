package com.android.kotlin_test1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.android.kotlin_test1.databinding.ActivityMainBinding
import com.android.kotlin_test1.test2.Test2Activity
import com.android.kotlin_test1.test5.util.DialogUtil
import com.android.kotlin_test1.util.Constants
import com.android.kotlin_test1.util.Loge
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel

@Route(path = Constants.PATH_MAIN_ACTIVITY)
class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    fun initView() {
        binding.kotlinAppTv.setOnClickListener {

        }
        binding.kotlinAppTv2.setOnClickListener() {
            ARouter.getInstance().build(Constants.PATH_TEST5_ACTIVITY).navigation()
        }
    }

    fun a(string: String, int: Context) {
        Loge.e(string)
    }


}