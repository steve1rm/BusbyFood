package me.androidbox.domain.local

import me.androidbox.domain.entity.ComplexSearchEntity

interface FoodLocal {
    suspend fun insertComplexSearch(listOfComplexSearchEntity: List<ComplexSearchEntity>)
}