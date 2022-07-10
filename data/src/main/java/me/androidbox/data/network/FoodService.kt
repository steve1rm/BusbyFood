package me.androidbox.data.network

import kotlinx.coroutines.flow.Flow
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.data.model.ResultModel
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodService {
    @GET(EndPoint.COMPLEX_SEARCH)
    suspend fun fetchComplexSearch(@Query("apiKey") apiKey: String): ResultModel
}