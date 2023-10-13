package com.android.kotlin_test1.test2.db

import com.android.kotlin_test1.test2.db.bean.User
import com.android.kotlin_test1.test2.db.dao.UserDao

class UserRepository(private val dao: UserDao) {

    val subscribers = dao.findAll()

    suspend fun insert(user: User):Long{
        return dao.insert(user)
    }

    suspend fun update(user: User):Int{
        return dao.update(user)
    }

    suspend fun delete(user: User) : Int{
        return dao.delete(user)
    }

    suspend fun deleteAll() {
        return dao.deleteAll()
    }
}
