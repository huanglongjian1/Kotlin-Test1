package com.android.kotlin_test1.test1;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.kotlin_test1.R;
import com.android.kotlin_test1.base.BaseActivity;
import com.android.kotlin_test1.databinding.Test1ActivityBinding;
import com.android.kotlin_test1.util.Constants;

@Route(path = Constants.PATH_TEST1_ACTIVITY)
public class Test1Activity extends BaseActivity<Test1ViewModel, Test1ActivityBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.test1_activity;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }


    @Override
    protected void initData() {

    }
}
