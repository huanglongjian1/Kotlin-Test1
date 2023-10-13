package com.android.kotlin_test1.test2.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.kotlin_test1.test2.db.bean.Person

@Dao
interface PersonDao_kotlin {
    @Query("select * from Person")
    fun getPersons(): List<Person>

    @Query("select * from Person")
    fun getLiveData(): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: Person)

    @Query("delete  from Person")
    fun deleteAll()
}