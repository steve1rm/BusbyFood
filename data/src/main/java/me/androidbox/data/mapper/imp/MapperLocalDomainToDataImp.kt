package me.androidbox.data.mapper.imp

import me.androidbox.data.localstorage.ComplexSearchLocalModel
import me.androidbox.data.mapper.MapperDomainToData
import me.androidbox.domain.entity.ComplexSearchEntity
import javax.inject.Inject

class MapperLocalDomainToDataImp @Inject constructor() : MapperDomainToData<ComplexSearchEntity, ComplexSearchLocalModel> {
    override fun map(entity: ComplexSearchEntity): ComplexSearchLocalModel {
        return ComplexSearchLocalModel(
            entity.id,
            entity.title,
            entity.image,
        )
    }
}