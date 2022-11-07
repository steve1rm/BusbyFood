package me.androidbox.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.androidbox.data.utils.Constant

@Entity(tableName = Constant.COMPLEX_SEARCH_LOCAL_TABLE)
data class ComplexSearchLocalModel(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo
    val title: String,

    @ColumnInfo
    val imagePath: String
)
