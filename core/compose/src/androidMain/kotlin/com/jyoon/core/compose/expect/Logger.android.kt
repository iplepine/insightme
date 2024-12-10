package com.jyoon.core.compose.expect

import android.util.Log
import com.jyoon.core.log.Logger

class AndroidLogger : Logger {
    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}

actual fun getLogger(): Logger = AndroidLogger()
