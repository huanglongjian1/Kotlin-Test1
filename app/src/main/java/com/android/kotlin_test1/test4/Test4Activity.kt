package com.android.kotlin_test1.test4

import android.os.Bundle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.kotlin_test1.R
import com.android.kotlin_test1.base.BaseActivity
import com.android.kotlin_test1.databinding.Test4ActivityBinding
import com.android.kotlin_test1.test2.db.AppDatabase
import com.android.kotlin_test1.test4.bean.JavaBean
import com.android.kotlin_test1.test4.bean.JavaBeanDao
import com.android.kotlin_test1.test4.bean.JavaBeanDao_kt
import com.android.kotlin_test1.test4.db.StudentDB_Kotlin
import com.android.kotlin_test1.test4.db.StudentDatabase
import com.android.kotlin_test1.test4.db.bean.Student
import com.android.kotlin_test1.test4.db.dao.StudentDao
import com.android.kotlin_test1.test4.retrofit.MainViewModel
import com.android.kotlin_test1.util.Constants
import com.android.kotlin_test1.util.Loge
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.random.Random


class Test4Activity : BaseActivity<MainViewModel, Test4ActivityBinding>() {
    override fun getContentViewId(): Int {
        return R.layout.test4_activity
    }

    val studentDao by lazy {
        StudentDB_Kotlin.testdb.studentDao()
    }

    override fun initData() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.test4ActivityTv.setOnClickListener {
            studentDao.insert(Student(0, "huanglongjian", 25))
        }
        studentDao.getStudents().observe(this) {
            Loge.e(it.toString())
        }
    }


}
