package com.android.kotlin_test1.test4

import android.provider.ContactsContract.CommonDataKinds.Email

data class User(var id: Int, var name: String, var email: Email, var avatar: String)
