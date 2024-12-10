package com.jyoon.feature.sleeptracker.domain

import com.jyoon.core.extensions.toFormattedString
import kotlinx.datetime.Instant
import kotlin.time.Duration
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
data class SleepRecord(
    val id: String = Uuid.random().toString(),
    val startTime: Instant,
    val endTime: Instant,
    val sleepingQuality: Int,
    val notes: String
) {
    val startTimeString: String = startTime.toFormattedString("yyyy-MM-dd HH:mm")
    val endTimeString = endTime.toFormattedString("yyyy-MM-dd HH:mm")

    private val duration: Duration = endTime.minus(startTime)
    val durationString = getDurationString(duration)

    /**
     * Duration 을 HH:mm 형태로 변환
     */
    private fun getDurationString(duration: Duration): String {
        val hours = duration.inWholeHours.toInt()
        val minutes = (duration.inWholeMinutes - hours * 60).toInt()
        return "${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}"
    }
}