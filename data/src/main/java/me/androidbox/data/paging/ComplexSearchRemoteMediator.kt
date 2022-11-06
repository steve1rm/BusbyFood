package me.androidbox.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import me.androidbox.data.BuildConfig
import me.androidbox.data.localstorage.FoodDatabase
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.data.model.ComplexSearchRemoteKey
import me.androidbox.data.model.ResultModel
import me.androidbox.data.network.FoodService
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class ComplexSearchRemoteMediator @Inject constructor(
    private val foodService: FoodService,
    private val foodDatabase: FoodDatabase
) : RemoteMediator<Int, ComplexSearchModel>() {

    private val foodDao = foodDatabase.foodDao()
    private val complexSearchRemoteKeyDao = foodDatabase.complexSearchRemoteKeyDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ComplexSearchModel>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKey = getRemoteKeyClosetToCurrentPosition(state)
                    remoteKey?.nextPage?.minus(10) ?: 10
                }

                LoadType.PREPEND -> {
                    val remoteKey = getRemoteKeyForFirstItem(state)
                    val previousPage = remoteKey?.previousPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKey != null
                        )

                    previousPage
                }

                LoadType.APPEND -> {
                    val remoteKey = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKey?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKey != null)

                    nextPage
                }
            }

            val response = foodService.fetchComplexSearch(BuildConfig.API, offset = currentPage)
            val endOfPaginationReached = response.results.isEmpty()

            val previousPage = if (currentPage == 10) null else currentPage - 10
            val nextPage = if (endOfPaginationReached) null else currentPage + 10

            foodDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    complexSearchRemoteKeyDao.deleteAllComplexSearchRemoteKey()
                    foodDao.deleteAllComplexSearch()
                }

                val listOfComplexRemoteKey = response.results.map { complexSearchModel ->
                    ComplexSearchRemoteKey(
                        remoteId = complexSearchModel.id,
                        previousPage = previousPage,
                        nextPage = nextPage
                    )
                }

                complexSearchRemoteKeyDao.addAllComplexSearchRemoteKey(listOfComplexRemoteKey)
                foodDao.insertAll(complexSearchModel = response.results)
            }

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        }
        catch (exception: Exception) {
            return MediatorResult.Error(exception)
        }
    }


    private suspend fun getRemoteKeyClosetToCurrentPosition(state: PagingState<Int, ComplexSearchModel>): ComplexSearchRemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                complexSearchRemoteKeyDao.getComplexSearchRemoteKey(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ComplexSearchModel>): ComplexSearchRemoteKey? {
        return state.pages.firstOrNull { page ->
            page.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { complexSearchModel ->
                complexSearchRemoteKeyDao.getComplexSearchRemoteKey(id = complexSearchModel.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ComplexSearchModel>): ComplexSearchRemoteKey? {
/*
        return state.lastItemOrNull()?.let { complexSearchModel ->
            complexSearchRemoteKeyDao.getComplexSearchRemoteKey(complexSearchModel.id)
        }
*/

        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { search ->
                complexSearchRemoteKeyDao.getComplexSearchRemoteKey(id = search.id)
            }
    }
}