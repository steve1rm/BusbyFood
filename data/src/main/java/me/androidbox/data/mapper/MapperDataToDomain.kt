package me.androidbox.data.mapper

interface MapperDataToDomain<in M, out E> {
    fun map(model: M): E
}