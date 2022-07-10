package me.androidbox.data.mapper.imp

import me.androidbox.data.mapper.MapperDomainToData
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.domain.entity.ComplexSearchEntity
import javax.inject.Inject

class MapperDomainToDataImp @Inject constructor(): MapperDomainToData<ComplexSearchEntity, ComplexSearchModel> {
    override fun map(entity: ComplexSearchEntity): ComplexSearchModel {
        return ComplexSearchModel(
            id = entity.id,
            title = entity.title,
            image = entity.image,
            imageType = entity.imageType
        )
    }
}
