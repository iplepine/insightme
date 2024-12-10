package com.jyoon.core.domain

interface BaseSuspendUseCase<Param, Result> {
    suspend operator fun invoke(param: Param): Result
}