package com.android.kotlin_test1.test4.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.android.kotlin_test1.test4.db.bean.Student
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Dao
interface StudentDao {
    @Query("select * from Student")
    fun getStudents(): LiveData<List<Student>>

    @Query("select * from student where id=:id limit 1")
    fun getStudent(id: Int): LiveData<Student>

    @Query("select * from student where id=:id limit 1")
    fun getStudent_(id: Int): Student

    @ExperimentalCoroutinesApi
    fun getAllDistinctUntilChanged() = getStudent(1).distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(student: Student)

    @Update
    fun update(student: Student)
}