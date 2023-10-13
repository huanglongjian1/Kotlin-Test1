package com.android.kotlin_test1.test3.one

import androidx.databinding.BaseObservable

class LoginInfo: BaseObservable() {
    var name: String = ""
        set(value) {
            if (name != value) {
                field = value
                notifyChange()
            }
        }
    var pwd: String = ""
        set(value) {
            if (pwd != value) {
                field = value
                notifyChange()
            }
        }
    var state: String = ""
        set(value) {
            field = value
            notifyChange()
        }
}
