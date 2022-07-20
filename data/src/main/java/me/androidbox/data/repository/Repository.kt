package me.androidbox.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.androidbox.data.model.ComplexSearchModel

interface Repository {
    fun fetchAllComplexSearch(): Flow<PagingData<ComplexSearchModel>>
}