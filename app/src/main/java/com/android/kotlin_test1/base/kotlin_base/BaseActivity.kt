package com.android.kotlin_test1.base.kotlin_base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.android.kotlin_test1.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseActivity<VM : BaseViewModel, VDB : ViewDataBinding> : AppCompatActivity(),
    CoroutineScope by MainScope() {
    protected lateinit var binding: VDB
    protected lateinit var mViewModel: VM;
    override fun onDestroy() {
        cancel()
        super.onDestroy()
    }

    private fun createViewModel() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = javaClass.simpleName
        binding = DataBindingUtil.setContentView(this, getContentViewId())
        createViewModel()
        initData()
        initView(savedInstanceState)
    }

    abstract fun getContentViewId(): Int
    abstract fun initData()
    abstract fun initView(savedInstanceState: Bundle?)

}
