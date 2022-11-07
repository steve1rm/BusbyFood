package me.androidbox.data.repository

import androidx.paging.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import me.androidbox.data.localstorage.FoodDatabase
import me.androidbox.data.network.FoodService
import me.androidbox.data.paging.ComplexSearchRemoteMediator
import me.androidbox.data.utils.Constant.ITEMS_PER_PAGE_DEFAULT
import me.androidbox.domain.entity.ComplexSearchEntity
import me.androidbox.domain.remote.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val foodService: FoodService,
    private val foodDatabase: FoodDatabase) : Repository {

    @OptIn(ExperimentalPagingApi::class)
    override fun fetchAllComplexSearch(): Flow<PagingData<ComplexSearchEntity>> {
        val pagingSourceFactory = { foodDatabase.foodDao().fetchAllComplexSearchPaging() }

        val pagingDataResult = Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE_DEFAULT),
            remoteMediator = ComplexSearchRemoteMediator(
                foodDatabase = foodDatabase, foodService = foodService
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow

        val data = pagingDataResult.map { pagingData ->
            pagingData.map { complexSearchModel ->
                        ComplexSearchEntity(
                            complexSearchModel.id,
                            complexSearchModel.title,
                            complexSearchModel.image,
                            complexSearchModel.imageType
                        )
            }
        }

        return data
    }
}

// Flow<PagingData<ComplexSearchModel>> Flow<ResponseState<List<ComplexSearchEntity>>>