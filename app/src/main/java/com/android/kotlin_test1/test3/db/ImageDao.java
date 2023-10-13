package com.android.kotlin_test1.test3.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDao {
    @Query("select * from ImagePng")
    List<ImagePng> getImageAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImage(ImagePng imagePng);

}
