package com.jyoon.core.compose.compositionlocal

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.jyoon.core.compose.expect.getLogger
import com.jyoon.core.log.Logger

val LoggerCompositionLocal: ProvidableCompositionLocal<Logger> = staticCompositionLocalOf {
    getLogger()
}