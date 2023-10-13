package com.android.kotlin_test1.test5

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.kotlin_test1.R
import com.android.kotlin_test1.base.BaseActivity
import com.android.kotlin_test1.databinding.Test5ActivityBinding
import com.android.kotlin_test1.test5.fragment02.Test5Fragment_02
import com.android.kotlin_test1.util.Constants

@Route(path = Constants.PATH_TEST5_ACTIVITY)
class Test5Activity : BaseActivity<Test5ViewModel, Test5ActivityBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.test5_activity
    }

    override fun initView(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.test5_activity_fragment, Test5Fragment_02())
            .commit()
    }

    override fun initData() {

    }
}