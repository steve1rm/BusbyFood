package me.androidbox.domain.usecase.imp

import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.local.FoodLocal
import me.androidbox.domain.usecase.InsertComplexSearchUseCase
import javax.inject.Inject

class InsertComplexSearchUseCaseImp @Inject constructor(private val foodLocal: FoodLocal) : InsertComplexSearchUseCase {
    override suspend fun execute(listOfComplexSearchEntity: List<ComplexSearchEntity>) {
        foodLocal.insertComplexSearch(listOfComplexSearchEntity)
    }
}