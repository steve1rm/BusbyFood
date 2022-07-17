package me.androidbox.domain.usecase

import me.androidbox.domain.entity.ComplexSearchEntity

interface InsertComplexSearchUseCase {
    suspend fun execute(listOfComplexSearchEntity: List<ComplexSearchEntity>)
}
