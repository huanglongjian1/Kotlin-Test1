package com.android.kotlin_test1.test4.bean

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface JavaBeanDao_kt {
    @Query("select * from JavaBean")
    fun getFlowUsers(): Flow<List<JavaBean>>

    @Query("select * from JavaBean")
    fun getUsers(): List<JavaBean>

    @Query("select * from JavaBean where name=:name")
    fun getUser(name: String): Flow<JavaBean>
    fun getUserDistinctUntilChanged(name: String) =
        getUser(name).distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(javaBean: JavaBean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(javaBeans: List<JavaBean>)

    @Delete
    fun delete(javaBean: JavaBean)

    @Update
    fun update(javaBean: JavaBean)
}