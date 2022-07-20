package me.androidbox.data.localstorage

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.androidbox.data.model.ComplexSearchLocalModel
import me.androidbox.data.model.ComplexSearchModel

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(complexSearchLocalModel: ComplexSearchLocalModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(complexSearchModel: List<ComplexSearchModel>)

    @Query("SELECT * FROM complex_search_local_table")
    fun fetchAllComplexSearch(): Flow<List<ComplexSearchLocalModel>>

    @Query("SELECT * FROM complex_search_table")
    fun fetchAllComplexSearchPaging(): PagingSource<Int, ComplexSearchModel>

    @Query("DELETE FROM complex_search_table")
    suspend fun deleteAllComplexSearch()
}