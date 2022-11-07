package me.androidbox.domain.usecase.imp

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.remote.Repository
import me.androidbox.domain.responsestate.ResponseState
import me.androidbox.domain.usecase.FetchComplexSearchPagingUseCase
import javax.inject.Inject

class FetchComplexSearchPagingUseCaseImp @Inject constructor(private val repository: Repository)
    : FetchComplexSearchPagingUseCase {

    override fun execute(): Flow<PagingData<ComplexSearchEntity>> {
        return repository.fetchAllComplexSearch()
    }
}