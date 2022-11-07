package me.androidbox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.androidbox.data.utils.Constant

@Entity(tableName = Constant.COMPLEX_SEARCH_TABLE)
data class ComplexSearchModel(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String
)
