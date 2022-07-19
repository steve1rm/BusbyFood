package me.androidbox.domain.usecase

import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.responsestate.ResponseState

interface FetchComplexSearchUseCase {
    fun execute(): Flow<ResponseState<List<ComplexSearchEntity>>>
}