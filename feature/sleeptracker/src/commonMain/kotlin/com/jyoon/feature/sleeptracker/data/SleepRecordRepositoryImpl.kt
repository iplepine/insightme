package com.jyoon.feature.sleeptracker.data

import com.jyoon.feature.sleeptracker.domain.SleepRecord
import com.jyoon.feature.sleeptracker.domain.SleepRecordRepository

class SleepRecordRepositoryImpl() : SleepRecordRepository {
    private val fakeDatabase: MutableMap<String, SleepRecord> = hashMapOf()

    override suspend fun getSleepRecords(): List<SleepRecord> {
        return fakeDatabase.toList().map { it.second }
    }

    override suspend fun getSleepRecords(
        startTimeInMilli: Long,
        endTimeInMilli: Long
    ): List<SleepRecord> {
        return fakeDatabase.toList().map { it.second }
    }

    override suspend fun getSleepRecord(id: Int): SleepRecord {
        return fakeDatabase[id.toString()]
            ?: throw IllegalArgumentException("No sleep record found with id $id")
    }

    override suspend fun addSleepRecord(sleepRecord: SleepRecord) {
        fakeDatabase[sleepRecord.id] = sleepRecord
    }

    override suspend fun updateSleepRecord(sleepRecord: SleepRecord) {
        fakeDatabase[sleepRecord.id] = sleepRecord
    }

    override suspend fun deleteSleepRecord(id: Int) {
        fakeDatabase.remove(id.toString())
    }
}