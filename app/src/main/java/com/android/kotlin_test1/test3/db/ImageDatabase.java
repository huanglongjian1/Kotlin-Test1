package com.android.kotlin_test1.test3.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.kotlin_test1.test2.db.AppDatabase;

@Database(entities = {ImagePng.class}, version = 1,exportSchema = true)
public abstract class ImageDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "image.db";
    private static volatile ImageDatabase mInstance;

    /**
     * 单例模式
     */
    public static ImageDatabase getInstance(Context context) {
        if (mInstance == null) {
            synchronized (AppDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                                    ImageDatabase.class, DATABASE_NAME)
                           // .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return mInstance;
    }

    public abstract ImageDao imageDao();
}
