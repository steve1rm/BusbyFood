package me.androidbox.data.localstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(complexSearchLocalModel: ComplexSearchLocalModel)

    @Query("SELECT * FROM ComplexSearchLocalModel")
    fun fetchAllComplexSearch(): Flow<List<ComplexSearchLocalModel>>
}