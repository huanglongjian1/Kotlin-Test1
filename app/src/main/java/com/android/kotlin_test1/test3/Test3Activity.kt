package com.android.kotlin_test1.test3

import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.kotlin_test1.databinding.Test3ActivityBinding
import com.android.kotlin_test1.util.Constants
import com.android.kotlin_test1.util.Loge
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.properties.Delegates

@Route(path = Constants.PATH_TEST3_ACTIVITY)
class Test3Activity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: Test3ActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Test3ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //获取ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //对加载状态进行动态观察
        viewModel.loadState.observe(this, Observer {
            when (it) {
                LoadState.Success -> binding.button.isEnabled = true
                LoadState.Fail -> {
                    binding.button.isEnabled = true
                    Toast.makeText(this, "it.msg", Toast.LENGTH_SHORT).show()
                }
                LoadState.Loading -> {
                    binding.button.isEnabled = false
                }
            }

        })

        //对图片Url数据进行观察
        viewModel.imageData.observe(this, Observer {
            //用Glide加载三张图片
            Glide.with(this)
                .load(it[0])
                .into(binding.imageView1)
            Glide.with(this)
                .load(it[1])
                .into(binding.imageView2)
            Glide.with(this)
                .load(it[2])
                .into(binding.imageView3)
        })

        //点击刷新按钮来网络加载
        binding.button.setOnClickListener {
            viewModel.getData()
        }

        binding.getImage.setOnClickListener {
            try {
                viewModel.getCSDNImage()
            } catch (e: Throwable) {
                Loge.e(e.message)
            }
        }
        viewModel.imageCSDNData.observe(this) {
            val bitmap = BitmapFactory.decodeStream(it.byteStream())
            binding.image.setImageBitmap(bitmap)
        }


        testDelay()


    }

    fun testDelay() {
        val uiScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    }

}


