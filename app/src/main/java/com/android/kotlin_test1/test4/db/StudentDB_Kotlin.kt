package com.android.kotlin_test1.test4.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.kotlin_test1.MyAPP
import com.android.kotlin_test1.test4.bean.JavaBean
import com.android.kotlin_test1.test4.bean.JavaBeanDao
import com.android.kotlin_test1.test4.bean.JavaBeanDao_kt
import com.android.kotlin_test1.test4.db.bean.Student
import com.android.kotlin_test1.test4.db.dao.StudentDao

@Database(entities = [Student::class, JavaBean::class], version = 1, exportSchema = false)
abstract class StudentDB_Kotlin : RoomDatabase() {
    /**
     * 获取 数据库访问 对象
     * 这是必须要实现的函数
     */
    abstract fun studentDao(): StudentDao
    abstract fun javaBeanDao_kt(): JavaBeanDao_kt


    companion object {
        @JvmStatic
        val testdb: StudentDB_Kotlin by lazy {
            Room.databaseBuilder(MyAPP.getApplication(), StudentDB_Kotlin::class.java, "test.db")
                .allowMainThreadQueries()
                .build()
        }
        lateinit var instance: StudentDB_Kotlin

        fun inst(context: Context): StudentDB_Kotlin {
            if (!::instance.isInitialized) {
                synchronized(StudentDB_Kotlin::class) {
                    // 创建数据库
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentDB_Kotlin::class.java,
                        "student_database.db"
                    )
                        .allowMainThreadQueries() // Room 原则上不允许在主线程操作数据库
                        // 如果要在主线程操作数据库需要调用该函数
                        .build()
                }
            }
            return instance;
        }
    }


}