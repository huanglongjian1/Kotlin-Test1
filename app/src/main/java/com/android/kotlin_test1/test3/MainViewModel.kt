package com.android.kotlin_test1.test3

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.kotlin_test1.MyAPP
import com.android.kotlin_test1.base.BaseViewModel
import com.android.kotlin_test1.test3.db.ImageDatabase
import com.android.kotlin_test1.test3.db.ImagePng
import com.android.kotlin_test1.util.Loge
import io.reactivex.rxjava3.core.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import java.io.IOException

class MainViewModel(app: Application) : BaseViewModel(app) {

    val imageData = MutableLiveData<List<String>>()
    val loadState = MutableLiveData<LoadState>()

    val imageCSDNData = MutableLiveData<ResponseBody>()
    val imagePngData = MutableLiveData<ByteArray>()
    fun getData() {
        viewModelScope.launch {
            try {
                loadState.value = LoadState.Loading

                val data1 = async { NetworkService.apiService.getImage() }
                val data2 = async { NetworkService.apiService.getImage() }
                val data3 = async { NetworkService.apiService.getImage() }
                imageData.value = listOf(data1.await(), data2.await(), data3.await()).map {
                    it.imgurl
                }

                loadState.value = LoadState.Success
            } catch (e: Throwable) {
                loadState.value = LoadState.Fail
                // 这里统一处理错误
                ExceptionUtil.catchException(e)
            }
        }
    }

    fun getCSDNImage() {
        viewModelScope.launch {
            try {
                loadState.value = LoadState.Loading
                val data = async {
                    NetworkService.apiService.getCSDNImage()
                }
                imageCSDNData.value = data.await()
                loadState.value = LoadState.Success

            } catch (e: Throwable) {
                loadState.value = LoadState.Fail
                // 这里统一处理错误
                ExceptionUtil.catchException(e)
            }
        }

    }

    fun getCSDNImageObservable() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (ImageDatabase.getInstance(application).imageDao().imageAll.size <= 0) {
                    viewModelScope.launch {
                        Loge.e("网络取图片")
                        loadState.value = LoadState.Loading
                        NetworkService.apiService.getCSDNImageObservable()
                            .retryWhen(RetryWithDelay(3, 3000))
                            .subscribe({
                                var imagePng = ImagePng();
                                imagePng.name = "${it.contentLength()}";
                                try {
                                    imagePng.image = it.bytes();
                                } catch (e: IOException) {
                                    e.printStackTrace();
                                }
                                Loge.e("${imagePng.image.size}===");
                                ImageDatabase.getInstance(application).imageDao()
                                    .insertImage(imagePng);
                                imagePngData.postValue(imagePng.image)
                                loadState.postValue(LoadState.Success)
                            }, {
                                Loge.e("处理错误")
                                loadState.value = LoadState.Fail
                                // 这里统一处理错误
                                ExceptionUtil.catchException(it)
                            })
                    }
                } else {
                    viewModelScope.launch {
                        withContext(Dispatchers.IO) {
                            Loge.e("数据库取图片"+Thread.currentThread().name)
                            val imagePng =
                                ImageDatabase.getInstance(application).imageDao().imageAll[0]
                            imagePngData.value = imagePng.image
                            loadState.value = LoadState.Success
                        }
                    }
                }
            }
        }
    }

}

