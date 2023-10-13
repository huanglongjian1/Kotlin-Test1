package com.android.kotlin_test1.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

//继承AndroidViewModel，是因为里面要用context时候直接可以getApplication()
public class BaseViewModel extends AndroidViewModel {
    public MutableLiveData<String> fail = new MutableLiveData<>();
    protected Application application;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }

    public MutableLiveData<String> getFail() {
        return fail;
    }
}
