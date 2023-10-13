package com.android.kotlin_test1.test2.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.kotlin_test1.test2.db.bean.Person;
import com.android.kotlin_test1.test2.db.bean.User;
import com.android.kotlin_test1.test2.db.dao.PersonDao;
import com.android.kotlin_test1.test2.db.dao.PersonDao_kotlin;
import com.android.kotlin_test1.test2.db.dao.UserDao;
import com.android.kotlin_test1.test4.bean.JavaBean;
import com.android.kotlin_test1.test4.bean.JavaBeanDao;

@Database(entities = {Person.class, User.class, JavaBean.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "app.db";
    private static volatile AppDatabase mInstance;

    /**
     * 单例模式
     */
    public static AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, DATABASE_NAME)
                            //  .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return mInstance;
    }

    public abstract PersonDao personDao();

    public abstract PersonDao_kotlin personDao_kotlin();

    public abstract UserDao userDao();

    public abstract JavaBeanDao javaBeanDao();
}
