package com.jyoon.core.compose.expect

import android.os.Build
import com.jyoon.core.appinfo.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()