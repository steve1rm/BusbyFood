package me.androidbox.busbyfood.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.responsestate.ResponseState
import me.androidbox.domain.usecase.FetchComplexSearchPagingUseCase
import me.androidbox.domain.usecase.FetchComplexSearchUseCase
import me.androidbox.domain.usecase.InsertComplexSearchUseCase
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    private val fetchComplexSearchUseCase: FetchComplexSearchUseCase,
    private val insertComplexSearchUseCase: InsertComplexSearchUseCase,
    private val fetchComplexSearchPagingUseCase: FetchComplexSearchPagingUseCase
) : ViewModel() {

    private val complexSearchMutableStateFlow = MutableStateFlow<ResponseState<List<ComplexSearchEntity>>>(ResponseState.idle)
    val complexSearchStateFlow = complexSearchMutableStateFlow.asStateFlow()
    private val complexSearchPagingMutableStateFlow = MutableStateFlow<PagingData<ResponseState.Success<List<ComplexSearchEntity>>>>(PagingData.empty())
    val complexSearchPagingStateFlow = complexSearchMutableStateFlow.asStateFlow()

    fun fetchComplexSearch() {
        viewModelScope.launch {
            complexSearchMutableStateFlow.update {
                ResponseState.Loading
            }

            fetchComplexSearchUseCase.execute().collect { responseState ->
                complexSearchMutableStateFlow.update { _ ->
                    responseState
                }
            }
        }
    }

    // Flow<PagingData<ComplexSearchModel>>
    fun fetchComplexSearchPaging(): Flow<PagingData<ComplexSearchEntity>> {
        complexSearchMutableStateFlow.update {
            ResponseState.Loading
        }

        return fetchComplexSearchPagingUseCase.execute()
    }

    fun insertComplexSearchToLocalStorage(listOfComplexSearchEntity: List<ComplexSearchEntity>) {
        viewModelScope.launch {
            insertComplexSearchUseCase.execute(listOfComplexSearchEntity)
        }
    }
}