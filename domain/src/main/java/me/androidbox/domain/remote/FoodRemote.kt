package me.androidbox.domain.remote

import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity

interface FoodRemote {
    fun complexSearch(apiKey: String): Flow<List<ComplexSearchEntity>>
}
