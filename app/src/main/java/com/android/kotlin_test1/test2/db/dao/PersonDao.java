package com.android.kotlin_test1.test2.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.android.kotlin_test1.test2.db.bean.Person;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Person person);

    @Query("select * from Person")
    LiveData<List<Person>> getLiveDataPersons();

    @Query("delete  from Person")
    void deleteAll();
}
