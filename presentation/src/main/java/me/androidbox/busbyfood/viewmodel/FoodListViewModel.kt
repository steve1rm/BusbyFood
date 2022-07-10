package me.androidbox.busbyfood.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.androidbox.busbyfood.BuildConfig
import me.androidbox.domain.usecase.FetchComplexSearchUseCase
import javax.inject.Inject

@HiltViewModel
class FoodListViewModel @Inject constructor(
    private val fetchComplexSearchUseCase: FetchComplexSearchUseCase
) : ViewModel() {

    fun fetchComplexSearch() {
        viewModelScope.launch {
            fetchComplexSearchUseCase.execute(BuildConfig.API).collect { complexSearchEntity ->
                println(complexSearchEntity)
            }
        }
    }
}