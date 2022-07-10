package me.androidbox.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.androidbox.data.mapper.MapperDataToDomain
import me.androidbox.data.mapper.MapperDomainToData
import me.androidbox.data.mapper.imp.MapperDataToDomainImp
import me.androidbox.data.mapper.imp.MapperDomainToDataImp
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.domain.entity.ComplexSearchEntity

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun bindsMapperDomainToData(mapperDomainToDataImp: MapperDomainToDataImp): MapperDomainToData<ComplexSearchEntity, ComplexSearchModel>

    @Binds
    fun bindsMapperDataToDomain(mapperDataToDomainImp: MapperDataToDomainImp): MapperDataToDomain<ComplexSearchModel, ComplexSearchEntity>
}