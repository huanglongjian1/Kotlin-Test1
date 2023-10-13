package com.android.kotlin_test1.test3

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.kotlin_test1.R
import com.android.kotlin_test1.base.BaseViewModel
import com.android.kotlin_test1.base.kotlin_base.BaseActivity
import com.android.kotlin_test1.databinding.OneBinding
import com.android.kotlin_test1.databinding.Test3ActivityBinding
import com.android.kotlin_test1.test3.one.CusViewModel
import com.android.kotlin_test1.util.Constants
import com.android.kotlin_test1.util.Loge

@Route(path = Constants.PATH_TEST3_ACTIVITY_03)
class Test3Activity_03 : BaseActivity<CusViewModel, OneBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.one
    }

    override fun initData() {
        mViewModel = ViewModelProvider(this).get(CusViewModel::class.java)
        binding.cusViewModel = mViewModel
        binding.lifecycleOwner = this
    }

    override fun initView(savedInstanceState: Bundle?) {

    }


}


