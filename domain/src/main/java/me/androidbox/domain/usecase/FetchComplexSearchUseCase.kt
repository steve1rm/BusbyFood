package me.androidbox.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity

interface FetchComplexSearchUseCase {
    fun execute(): Flow<List<ComplexSearchEntity>>
}