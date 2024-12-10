package com.jyoon.core.compose.expect

import com.jyoon.core.log.Logger

class IosLogger : Logger {
    override fun d(tag: String, message: String) {
        println("$tag: $message")
    }
}

actual fun getLogger(): Logger = IosLogger()