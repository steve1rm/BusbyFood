package me.androidbox.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity

interface FetchComplexSearchPagingUseCase {
    fun execute(): Flow<PagingData<ComplexSearchEntity>>
}