package com.android.kotlin_test1.test5.fragment02

import android.os.Bundle
import android.provider.Settings.Global
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.android.kotlin_test1.base.retrofit.RetrofitBuilder.downloadApi
import com.android.kotlin_test1.base.retrofit.RetrofitBuilder.downloadApi2
import com.android.kotlin_test1.databinding.Test5FragmentBinding
import com.android.kotlin_test1.test5.Test5ViewModel
import com.android.kotlin_test1.util.Loge
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Test5Fragment_02 : Fragment() {
    private lateinit var binding: Test5FragmentBinding
    private lateinit var viewModel: Test5Fragment_02_VM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = Test5FragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(Test5Fragment_02_VM::class.java)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        binding.test5FragmentTv.setOnClickListener {

        }
        binding.test5FragmentTv2.setOnClickListener {


        }
        viewModel.searchText.observe(requireActivity()) {
            viewModel.getArticle()
        }
        viewModel.articleList.observe(requireActivity()) {
            Loge.e(it.toString())
        }
        lifecycleScope.launch {
            binding.test5FragmentEdittext2.textWatcherFlow().collect {
                Loge.e(it)
            }
        }
    }

    //获取关键字，TextView增加一个扩展函数。
    //callbackFlow会返回一个Flow
    private fun TextView.textWatcherFlow(): Flow<String> = callbackFlow {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                //往flow里面添加元素
                trySend(s.toString())
            }
        }
        addTextChangedListener(textWatcher)
        //flow关闭的时候移除监听
        awaitClose { removeTextChangedListener(textWatcher) }
    }

}


