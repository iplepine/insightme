package com.jyoon.core.compose.expect

import com.jyoon.core.appinfo.Platform
import com.jyoon.core.log.Logger

expect fun getLogger(): Logger
expect fun getPlatform(): Platform