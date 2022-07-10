package me.androidbox.data.mapper.imp

import me.androidbox.data.mapper.MapperDataToDomain
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.domain.entity.ComplexSearchEntity
import javax.inject.Inject

class MapperDataToDomainImp @Inject constructor() : MapperDataToDomain<ComplexSearchModel, ComplexSearchEntity> {
    override fun map(model: ComplexSearchModel): ComplexSearchEntity {
        return ComplexSearchEntity(
            id = model.id,
            title = model.title,
            image = model.image,
            imageType = model.imageType
        )
    }
}
