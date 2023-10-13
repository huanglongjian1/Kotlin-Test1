package com.android.kotlin_test1.test2

import android.app.Application
import androidx.lifecycle.LiveData
import com.android.kotlin_test1.base.BaseViewModel
import com.android.kotlin_test1.test2.db.AppDatabase
import com.android.kotlin_test1.test2.db.PersonRepository
import com.android.kotlin_test1.test2.db.UserDatabase
import com.android.kotlin_test1.test2.db.UserRepository
import com.android.kotlin_test1.test2.db.bean.Person
import com.android.kotlin_test1.test2.db.bean.User
import com.android.kotlin_test1.test2.db.dao.UserDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Test2ViewModel(application: Application) : BaseViewModel(application) {
    private lateinit var userRepository: UserRepository
    private lateinit var personRepository: PersonRepository

    val myLazyString: String by lazy { "Hello" }

    lateinit var liveData: LiveData<List<User>>
    lateinit var userDao: UserDao

    init {
        userRepository = UserRepository(AppDatabase.getInstance(application).userDao())
        personRepository = PersonRepository(AppDatabase.getInstance(application).personDao())

        userDao = UserDatabase.getInstance(application).userDao
    }

    public fun findAll(): LiveData<List<User>> {
        return userRepository.subscribers
    }

    public fun insert(user: User): Long? {
        var long: Long? = null
        GlobalScope.launch {
            long = userRepository.insert(user)
        }
        return long
    }

    public fun deleteAll() {
        GlobalScope.launch {
            userRepository.deleteAll()
        }
    }

    public fun getLiveDataPersons(): LiveData<MutableList<Person>> {
        return personRepository.personLiveData
    }

    public fun deleteAllPersons() {
        GlobalScope.async {
            personRepository.deleteAll()
        }
    }

    public fun insertPerson(person: Person) {
        GlobalScope.async {
            personRepository.insertPerson(person)
        }

    }


    public fun userInsert(user: User) {
        GlobalScope.launch {
            userDao.insert(
                user
            )
        }
    }
    public fun userDeleteAll(){
        GlobalScope.launch {
            userDao.deleteAll()
        }
    }
    public fun getUsers(): LiveData<List<User>> {
        liveData = userDao.findAll()
        return liveData

    }
}