package com.example.wishmeal.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Wish::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishDao(): WishDao
}