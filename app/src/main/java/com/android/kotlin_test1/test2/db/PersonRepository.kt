package com.android.kotlin_test1.test2.db

import com.android.kotlin_test1.test2.db.bean.Person
import com.android.kotlin_test1.test2.db.dao.PersonDao

class PersonRepository(private val personDao: PersonDao) {
    val personLiveData = personDao.liveDataPersons
    suspend fun insertPerson(person: Person) {
        personDao.insert(person)
    }

    suspend fun deleteAll() {
        personDao.deleteAll()
    }
}