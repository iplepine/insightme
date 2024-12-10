package com.jyoon.core.extensions

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime

@OptIn(FormatStringsInDatetimeFormats::class)
fun Instant.toFormattedString(
    pattern: String = "yyyy-MM-dd HH:mm:ss"
): String {
    val localDateTime = this.toLocalDateTime(TimeZone.currentSystemDefault())
    val formatter = LocalDateTime.Format {
        byUnicodePattern(pattern)
    }

    return formatter.format(localDateTime)
}

@OptIn(FormatStringsInDatetimeFormats::class)
fun LocalDateTime.toFormattedString(
    pattern: String = "yyyy-MM-dd HH:mm:ss"
): String {
    val formatter = LocalDateTime.Format {
        byUnicodePattern(pattern)
    }

    return formatter.format(this)
}
