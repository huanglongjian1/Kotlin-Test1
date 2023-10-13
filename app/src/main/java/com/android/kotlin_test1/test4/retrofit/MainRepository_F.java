package com.android.kotlin_test1.test4.retrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainRepository_F implements ViewModelProvider.Factory {
    Application application;

    public MainRepository_F(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        return (T) new MainViewModel(application);
    }
}
