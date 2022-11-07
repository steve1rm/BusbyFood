package me.androidbox.data.localstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.androidbox.data.model.ComplexSearchRemoteKey

@Dao
interface ComplexSearchRemoteKeyDao {

    @Query("SELECT * FROM complex_search_remote_keys_table WHERE id = :id")
    suspend fun getComplexSearchRemoteKey(id: Int): ComplexSearchRemoteKey

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllComplexSearchRemoteKey(listOfComplexSearchRemoteKey: List<ComplexSearchRemoteKey>)

    @Query("DELETE FROM complex_search_remote_keys_table")
    suspend fun deleteAllComplexSearchRemoteKey()
}
