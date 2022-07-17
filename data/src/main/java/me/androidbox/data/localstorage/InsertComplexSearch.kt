package me.androidbox.data.localstorage

import me.androidbox.data.mapper.MapperDomainToData
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.local.FoodLocal
import javax.inject.Inject

class InsertComplexSearch @Inject constructor(
    private val foodDao: FoodDao,
    private val mapperDomainToData: MapperDomainToData<@JvmSuppressWildcards ComplexSearchEntity, @JvmSuppressWildcards ComplexSearchLocalModel>
) : FoodLocal {

    override suspend fun insertComplexSearch(listOfComplexSearchEntity: List<ComplexSearchEntity>) {
        listOfComplexSearchEntity.forEach { complexSearchEntity ->
            foodDao.insert(mapperDomainToData.map(complexSearchEntity))
        }
    }
}