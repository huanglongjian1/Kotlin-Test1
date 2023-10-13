package com.android.kotlin_test1.test2.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.kotlin_test1.test2.db.bean.User

/**
 * @author: ffzs
 * @Date: 2020/9/11 下午5:08
 */

@Dao
interface UserDao {

    @Insert
    fun insert(user: User): Long

    @Update
    fun update(user: User): Int

    @Delete
    fun delete(user: User): Int

    @Query("DELETE FROM user_table")
    fun deleteAll()

    @Query("SELECT * FROM user_table")
    fun findAll(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun findById(id: Long): User

}
