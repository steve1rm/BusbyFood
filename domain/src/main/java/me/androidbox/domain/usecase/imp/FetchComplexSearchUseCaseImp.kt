package me.androidbox.domain.usecase.imp

import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.remote.FoodRemote
import me.androidbox.domain.responsestate.ResponseState
import me.androidbox.domain.usecase.FetchComplexSearchUseCase
import javax.inject.Inject

class FetchComplexSearchUseCaseImp @Inject constructor(private val foodRemote: FoodRemote) : FetchComplexSearchUseCase {
    override fun execute(): Flow<ResponseState<List<ComplexSearchEntity>>> {
        return foodRemote.complexSearch()
    }
}