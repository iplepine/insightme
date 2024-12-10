package com.jyoon.feature.sleeptracker.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.test.Test

class SleepRecordTest {

    @Test
    fun testSleepDuration() {
        val sleepRecord = SleepRecord(
            id = 1,
            startTime = LocalDateTime(2023, 1, 1, 22, 0).toInstant(TimeZone.currentSystemDefault()),
            endTime = LocalDateTime(2023, 1, 2, 7, 0).toInstant(TimeZone.currentSystemDefault()),
            sleepingQuality = 5,
            notes = "Good"
        )

        println(sleepRecord.startTimeString)
        println(sleepRecord.endTimeString)
        println(sleepRecord.durationString)
    }
}