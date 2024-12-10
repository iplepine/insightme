package com.jyoon.feature.sleeptracker.domain

data class SleepRecord(
    val id: Int,
    val date: Date,
    val startTime: Long,
    val endTime: Long,
    val quality: Int,
    val notes: String
)