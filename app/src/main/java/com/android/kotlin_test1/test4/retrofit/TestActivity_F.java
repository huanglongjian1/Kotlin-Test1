package com.android.kotlin_test1.test4.retrofit;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.kotlin_test1.databinding.Test4ActivityBinding;
import com.android.kotlin_test1.test4.bean.JavaBean;
import com.android.kotlin_test1.test4.db.StudentDB_Kotlin;
import com.android.kotlin_test1.test4.db.bean.Student;
import com.android.kotlin_test1.test4.db.dao.StudentDao;
import com.android.kotlin_test1.util.Constants;
import com.android.kotlin_test1.util.Loge;

import java.util.List;

@Route(path = Constants.PATH_TEST4_ACTIVITY)
public class TestActivity_F extends AppCompatActivity {
    Test4ActivityBinding binding;
    MainViewModel mainViewModel;
    StudentDao studentDao;
    int index;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Test4ActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mainViewModel = new ViewModelProvider(this, new MainRepository_F(getApplication()))
                .get(MainViewModel.class);
        studentDao = StudentDB_Kotlin.getTestdb().studentDao();
        binding.test4ActivityTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = studentDao.getStudent_(1);
                student.setName("改名了" + index++);
                studentDao.update(student);
            }
        });
        binding.test4ActivityTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentDao.insert(new Student(0, "新增", 34));
            }
        });
        studentDao.getStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                Loge.e(students.toString());
            }
        });
        studentDao.getAllDistinctUntilChanged().observe(this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                Loge.e(student.toString());
            }
        });
        mainViewModel.getListUsers().observe(this, new Observer<List<JavaBean>>() {
            @Override
            public void onChanged(List<JavaBean> javaBeanList) {
                Loge.e(javaBeanList.toString());
            }
        });

    }
}
