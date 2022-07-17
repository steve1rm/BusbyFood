package me.androidbox.busbyfood.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.androidbox.busbyfood.BuildConfig
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.usecase.FetchComplexSearchUseCase
import me.androidbox.domain.usecase.InsertComplexSearchUseCase
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    private val fetchComplexSearchUseCase: FetchComplexSearchUseCase,
    private val insertComplexSearchUseCase: InsertComplexSearchUseCase
) : ViewModel() {

    private val complexSearchMutableStateFlow = MutableStateFlow<List<ComplexSearchEntity>>(emptyList())
    val complexSearchStateFlow = complexSearchMutableStateFlow.asStateFlow()

    fun fetchComplexSearch() {
        viewModelScope.launch {
            fetchComplexSearchUseCase.execute().collect { listOfComplexSearchEntity ->
                complexSearchMutableStateFlow.update {
                    listOfComplexSearchEntity
                }
            }
        }
    }

    fun insertComplexSearchToLocalStorage(listOfComplexSearchEntity: List<ComplexSearchEntity>) {
        viewModelScope.launch {
            insertComplexSearchUseCase.execute(listOfComplexSearchEntity)
        }
    }
}