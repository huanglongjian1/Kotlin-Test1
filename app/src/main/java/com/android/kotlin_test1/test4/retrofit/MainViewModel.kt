package com.android.kotlin_test1.test4.retrofit


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.android.kotlin_test1.MyAPP
import com.android.kotlin_test1.base.BaseViewModel
import com.android.kotlin_test1.test4.User
import com.android.kotlin_test1.test4.bean.JavaBean
import com.android.kotlin_test1.util.Loge
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import org.junit.Test
import org.junit.rules.Timeout
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainViewModel(application: Application) : BaseViewModel(application) {

    private var mainRepository: MainRepository = MainRepository()

    fun getListUsers() = liveData(Dispatchers.IO) {
        emit(mainRepository.getListUsers())

    }

    var liveData = MutableLiveData<List<JavaBean>>()
    fun getUsersObservable() {
        mainRepository.getUsersObservable().subscribeOn(Schedulers.io()).subscribe {
            liveData.postValue(it)
        }
    }

    fun getUsersObservable_02() = liveData(Dispatchers.IO) {
        suspendCoroutine {
            mainRepository.getUsersObservable().subscribe {
                viewModelScope.launch {
                    emit(it.toString())
                }
            }
            Loge.e("----------")
        }

    }

    fun getUsersFromNetAndRoom() = liveData(Dispatchers.IO) {
        emit(mainRepository.getUsersFromNetAndRoom())
    }

}
