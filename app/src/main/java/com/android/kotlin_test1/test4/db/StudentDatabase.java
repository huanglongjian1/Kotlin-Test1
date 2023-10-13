package com.android.kotlin_test1.test4.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.kotlin_test1.test2.db.AppDatabase;
import com.android.kotlin_test1.test4.db.bean.Student;
import com.android.kotlin_test1.test4.db.dao.StudentDao;




@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "student.db";
    private static volatile StudentDatabase mInstance;

    /**
     * 单例模式
     */
    public static StudentDatabase getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                                    StudentDatabase.class, DATABASE_NAME)
                            //.allowMainThreadQueries()
                            .build();
                }
            }
        }
        return mInstance;
    }

    public abstract StudentDao studentDao();
}
