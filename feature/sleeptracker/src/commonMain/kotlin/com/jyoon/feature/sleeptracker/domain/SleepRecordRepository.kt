package com.jyoon.feature.sleeptracker.domain

interface SleepRecordRepository {
    suspend fun getSleepRecords(): List<SleepRecord>
    suspend fun getSleepRecords(startTimeInMilli: Long, endTimeInMilli: Long): List<SleepRecord>
    suspend fun getSleepRecord(id: Int): SleepRecord
    suspend fun addSleepRecord(sleepRecord: SleepRecord)
    suspend fun updateSleepRecord(sleepRecord: SleepRecord)
    suspend fun deleteSleepRecord(id: Int)
}