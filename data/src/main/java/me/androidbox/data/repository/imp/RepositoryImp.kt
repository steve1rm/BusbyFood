package me.androidbox.data.repository.imp

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import me.androidbox.data.localstorage.FoodDatabase
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.data.network.FoodService
import me.androidbox.data.paging.ComplexSearchRemoteMediator
import me.androidbox.data.repository.Repository
import me.androidbox.data.utils.Constant.ITEMS_PER_PAGE_DEFAULT
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val foodService: FoodService,
    private val foodDatabase: FoodDatabase)  : Repository {

    @OptIn(ExperimentalPagingApi::class)
    override fun fetchAllComplexSearch(): Flow<PagingData<ComplexSearchModel>> {
        val pagingSourceFactory = { foodDatabase.foodDao().fetchAllComplexSearchPaging() }

        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE_DEFAULT),
            remoteMediator = ComplexSearchRemoteMediator(foodDatabase = foodDatabase, foodService = foodService
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}