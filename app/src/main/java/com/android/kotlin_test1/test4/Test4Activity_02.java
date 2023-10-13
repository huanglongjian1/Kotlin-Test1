package com.android.kotlin_test1.test4;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.kotlin_test1.R;
import com.android.kotlin_test1.base.BaseActivity;
import com.android.kotlin_test1.databinding.Test4ActivityBinding;
import com.android.kotlin_test1.test2.db.AppDatabase;
import com.android.kotlin_test1.test4.bean.JavaBean;
import com.android.kotlin_test1.test4.bean.JavaBeanDao;
import com.android.kotlin_test1.test4.db.StudentDB_Kotlin;
import com.android.kotlin_test1.test4.db.bean.Student;
import com.android.kotlin_test1.test4.retrofit.MainViewModel;
import com.android.kotlin_test1.util.Constants;
import com.android.kotlin_test1.util.Loge;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class Test4Activity_02 extends BaseActivity<MainViewModel, Test4ActivityBinding> {
    @Override
    protected int getContentViewId() {
        return R.layout.test4_activity;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    JavaBeanDao javaBeanDao;

    @Override
    protected void initData() {
        javaBeanDao = AppDatabase.getInstance(getApplication()).javaBeanDao();
        binding.test4ActivityTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                javaBeanDao.getLivedataJavabeans().observe(Test4Activity_02.this, new Observer<List<JavaBean>>() {
                    @Override
                    public void onChanged(List<JavaBean> javaBeanList) {
                        Loge.e(javaBeanList.size() + ":" + javaBeanList.toString());
                    }
                });
            }
        });
        mViewModel.getListUsers().observe(this, new Observer<List<JavaBean>>() {
            @Override
            public void onChanged(List<JavaBean> javaBeanList) {
                JavaBean[] javaBeans = javaBeanList.stream()
                        .collect(Collectors.toList()).toArray(new JavaBean[0]);
                Loge.e(javaBeans.length + ":" + javaBeans[0].toString());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        javaBeanDao.deleteAll();
                        javaBeanDao.insert(javaBeans);
                    }
                }).start();
            }
        });
        StudentDB_Kotlin.Companion.inst(this).studentDao().getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                Loge.e("stu:"+students.toString());
            }
        });
    }
}
