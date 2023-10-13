package com.android.kotlin_test1.test5.fragment02

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.kotlin_test1.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class Test5Fragment_02_VM(application: Application) : BaseViewModel(application) {
    private val TAG = this.javaClass.simpleName
    public fun cacheRepositityDemo() {
        val repositity = TestRepositity()
        viewModelScope.launch {
            repositity.getData().onStart {
                Log.d(TAG, "TestRepositity: onStart")
            }.onCompletion {
                Log.d(TAG, "TestRepositity: onCompletion")
            }.collect {
                Log.d(TAG, "collect: $it")
            }
        }
    }

    var searchText: MutableLiveData<String> = MutableLiveData()
    var articleList = MutableLiveData<List<String>>()
    fun getArticle() {
        if (searchText.value == null) return

        viewModelScope.launch {
            flow {
                emit(searchText.value)
            }.flowOn(Dispatchers.IO).catch { e ->
                e.printStackTrace()
            }.collect {
                it?.let {
                    val list = ArrayList<String>()
                    val exp = it
                    repeat(5) {
                        list.add(exp)
                    }
                    articleList.value = list
                }

            }
        }
    }
}