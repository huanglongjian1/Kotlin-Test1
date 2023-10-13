package com.android.kotlin_test1.test5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.kotlin_test1.R
import com.android.kotlin_test1.databinding.Test5FragmentBinding
import com.android.kotlin_test1.util.Loge
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


class Test5Fragment() : Fragment() {
    private lateinit var binding: Test5FragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Loge.e("-------")
        binding = DataBindingUtil.inflate<Test5FragmentBinding>(
            inflater,
            R.layout.test5_fragment,
            container,
            false
        );
        return binding.root
    }


    val list: ArrayList<String> by lazy {
        ArrayList<String>()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = activity?.let {
            ViewModelProvider(it)[Test5ViewModel::class.java]
        }
        binding.test5FragmentTv.setOnClickListener {
            viewModel?.setOnDialogListener(onConfirmListner = {
                Loge.e(it)
            }, onCancelListener = {
                Loge.e("取消")
            })
            viewModel?.returnString()
        }
        activity?.let {
            viewModel?.progress?.observe(it) {
                binding.test5Progress.progress = it
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            val result = flow {
                var num = 1
                while (num < 10) {
                    emit(num)
                    delay(300)
                    num++
                }
            }.reduce { a, b ->
                a + b
            }
            Loge.e("$result")
        }


    }

}




