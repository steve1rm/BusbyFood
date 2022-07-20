package me.androidbox.data.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import me.androidbox.data.model.ComplexSearchModel

@Database(entities = [
    ComplexSearchLocalModel::class,
    ComplexSearchModel::class], version = 1, exportSchema = false)
abstract class FoodDatabase: RoomDatabase() {
    abstract fun foodDao(): FoodDao
}
