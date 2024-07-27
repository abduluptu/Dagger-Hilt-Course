package com.soha.infotech.daggerhiltcourse

import android.util.Log
import javax.inject.Inject

const val TAG = "ANAM"

/*
class UserRepository @Inject constructor() {
    fun saveUser(email: String, password: String) {
        Log.d(TAG, "User saved in DB")
    }
}*/

// Constructor injection
/*class UserRepository @Inject constructor(private val loggerService: LoggerService) {
    fun saveUser(email: String, password: String) {
        loggerService.log("User saved in DB")
    }
}*/

/**
 * For module (We use module for any interface, abstract class and any third party component)
 * Because we can not create object of abstract class / interface
 */

interface UserRepository {
    fun saveUser(email: String, password: String)
}


class SQLRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        // Save User in DB
        Log.d(TAG, "User saved in DB")
    }
}

class FirebaseRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        // Save User in Firebase
        Log.d(TAG, "User saved in Firebase")
    }
}