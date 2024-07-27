package com.soha.infotech.daggerhiltcourse

import android.util.Log
import javax.inject.Inject

/**
 * Note: Suppose we are using any third party Logger Service
 */

class LoggerService @Inject constructor() {
    fun log(message: String) {
        Log.d(TAG, message)
    }
}