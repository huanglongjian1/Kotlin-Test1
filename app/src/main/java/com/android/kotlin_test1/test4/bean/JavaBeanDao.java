package com.android.kotlin_test1.test4.bean;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import kotlinx.coroutines.flow.Flow;

@Dao
public interface JavaBeanDao {
    @Query("select * from JavaBean")
    LiveData<List<JavaBean>> getLivedataJavabeans();

    @Query("select * from javabean")
    List<JavaBean> getListJavaBean();

    @Query("select * from javabean")
    List<JavaBean> getListJavaBean_Rxjava();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(JavaBean... javaBean);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<JavaBean> javaBeanList);

    @Query("delete from JavaBean")
    void deleteAll();
}
