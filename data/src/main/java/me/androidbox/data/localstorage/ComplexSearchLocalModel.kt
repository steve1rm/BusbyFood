package me.androidbox.data.localstorage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ComplexSearchLocalModel")
data class ComplexSearchLocalModel(
    @PrimaryKey
    val id: Int,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val imagePath: String
)
