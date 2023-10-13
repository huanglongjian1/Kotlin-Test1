package com.android.kotlin_test1.test2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.kotlin_test1.test2.db.bean.User
import com.android.kotlin_test1.test2.db.dao.UserDao

/**
 * @author: ffzs
 * @Date: 2020/9/11 下午5:15
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    // 通过伴生对象实现单例模式
    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_table.db"
                    ).build()
                }
                return instance
            }
        }
    }
}
