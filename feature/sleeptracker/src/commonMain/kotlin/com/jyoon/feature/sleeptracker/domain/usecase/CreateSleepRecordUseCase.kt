package com.jyoon.feature.sleeptracker.domain.usecase

import com.jyoon.feature.sleeptracker.domain.SleepRecord
import com.jyoon.feature.sleeptracker.domain.SleepRecordRepository

class CreateSleepRecordUseCase(
    private val sleepRecordRepository: SleepRecordRepository
) {
    suspend operator fun invoke(sleepRecord: SleepRecord) {
        sleepRecordRepository.addSleepRecord(sleepRecord)
    }
}