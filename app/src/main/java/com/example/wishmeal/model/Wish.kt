package com.example.wishmeal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wish(
    @PrimaryKey val uid : Int,
    @ColumnInfo(name = "wish_text") val wishText: String?,
    @ColumnInfo(name = "country") val country: String?,
    @ColumnInfo(name = "wish_completed") val wishCompleted: Boolean?
)
