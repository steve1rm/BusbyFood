package me.androidbox.domain.remote

import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.responsestate.ResponseState

interface FoodRemote {
    fun complexSearch(): Flow<ResponseState<List<ComplexSearchEntity>>>
}
