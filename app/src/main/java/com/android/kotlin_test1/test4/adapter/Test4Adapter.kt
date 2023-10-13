package com.android.kotlin_test1.test4.adapter

import android.content.Context
import com.android.kotlin_test1.R
import com.android.kotlin_test1.base.BaseRecyclerViewAdapter
import com.android.kotlin_test1.base.BindingViewHolder
import com.android.kotlin_test1.databinding.Test4RvItemBinding
import com.android.kotlin_test1.test4.bean.JavaBean

class Test4Adapter(context: Context) :
    BaseRecyclerViewAdapter<JavaBean, Test4RvItemBinding>(context) {
    override fun getRecyclerViewItemID(): Int {
        return R.layout.test4_rv_item
    }

    override fun onBindVH(holder: BindingViewHolder<*>?, position: Int) {
        var javaBean = data_list[position]
        var binding: Test4RvItemBinding = holder?.mBinding as Test4RvItemBinding
        binding.javabean = javaBean
        binding.executePendingBindings()
    }
}