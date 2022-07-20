package me.androidbox.data.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import me.androidbox.data.model.ComplexSearchLocalModel
import me.androidbox.data.model.ComplexSearchModel
import me.androidbox.data.model.ComplexSearchRemoteKey

@Database(entities = [
    ComplexSearchLocalModel::class,
    ComplexSearchModel::class,
    ComplexSearchRemoteKey::class], version = 1, exportSchema = false)
abstract class FoodDatabase: RoomDatabase() {
    abstract fun foodDao(): FoodDao
    abstract fun complexSearchRemoteKeyDao(): ComplexSearchRemoteKeyDao
}
