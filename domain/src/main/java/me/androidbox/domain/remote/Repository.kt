package me.androidbox.domain.remote

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity

interface Repository {
    fun fetchAllComplexSearch(): Flow<PagingData<ComplexSearchEntity>>
}