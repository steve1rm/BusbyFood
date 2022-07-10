package me.androidbox.data.mapper

interface MapperDomainToData <in E, out M> {
    fun map(entity: E): M
}
