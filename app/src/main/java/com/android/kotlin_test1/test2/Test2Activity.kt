package com.android.kotlin_test1.test2

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.kotlin_test1.R
import com.android.kotlin_test1.base.BaseActivity
import com.android.kotlin_test1.databinding.Test2ActivityBinding
import com.android.kotlin_test1.util.Constants
import com.android.kotlin_test1.util.Loge
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Route(path = Constants.PATH_TEST2_ACTIVITY)
class Test2Activity : BaseActivity<Test2ViewModel, Test2ActivityBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.test2_activity
    }


    fun testDelay() {
        GlobalScope.launch {
            println("before getName")
            var name = getUserName()
            println("after getName name:$name")
        }
        println("continue")
    }

    suspend fun getUserName(): String {
        return withContext(Dispatchers.IO) {
            //模拟网络获取
            Thread.sleep(2000)
            "fish"
        }
    }



    override fun initData() {
        binding.vm = mViewModel


    }


    override fun onDestroy() {

        super.onDestroy()
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.test2Tv.setOnClickListener {

        }
        binding.test2Insert.setOnClickListener {

        }
        binding.test2Query.setOnClickListener {

        }
        binding.test2Delete.setOnClickListener {
            mViewModel.userDeleteAll()
        }
    }
}
