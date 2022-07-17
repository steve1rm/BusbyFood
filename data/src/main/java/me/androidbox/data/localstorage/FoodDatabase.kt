package me.androidbox.data.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ComplexSearchLocalModel::class], version = 1, exportSchema = false)
abstract class FoodDatabase: RoomDatabase() {
    abstract fun foodDao(): FoodDao
}
