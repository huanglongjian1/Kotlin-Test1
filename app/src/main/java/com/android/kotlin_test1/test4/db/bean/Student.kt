package com.android.kotlin_test1.test4.db.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(@PrimaryKey(autoGenerate = true) val id: Int, var name: String, var age: Int)
