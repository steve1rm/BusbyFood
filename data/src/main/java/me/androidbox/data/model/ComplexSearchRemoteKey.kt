package me.androidbox.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.androidbox.data.utils.Constant

@Entity(tableName = Constant.COMPLEX_SEARCH_REMOTE_KEYS_TABLE)
data class ComplexSearchRemoteKey(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val remoteId: Int,
    val previousPage: Int?,
    val nextPage: Int?
)
