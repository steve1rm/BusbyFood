package me.androidbox.data.request

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.androidbox.data.mapper.MapperDataToDomain
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.data.network.FoodService
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.remote.FoodRemote
import javax.inject.Inject

class RequestComplexSearch @Inject constructor(
    private val foodService: FoodService,
    private val mapperDataToDomain: MapperDataToDomain<@JvmSuppressWildcards ComplexSearchModel, @JvmSuppressWildcards ComplexSearchEntity>) : FoodRemote {

    override fun complexSearch(apiKey: String): Flow<List<ComplexSearchEntity>> {
        return flow {
            val resultModel = foodService.fetchComplexSearch(apiKey)

            val listOfComplexSearchEntity = resultModel.results.map { complexSearchModel ->
                mapperDataToDomain.map(complexSearchModel)
            }

            emit(listOfComplexSearchEntity)
        }
    }
}
