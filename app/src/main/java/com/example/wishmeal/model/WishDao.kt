package com.example.wishmeal.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WishDao {
    @Query("SELECT * FROM wish")
    fun getAll() : List<Wish>

    @Query("SELECT * FROM wish WHERE wish_completed LIKE :wish_status")
    fun findByStatus(wish_status: Boolean): List<Wish>

    @Query("SELECT * FROM wish WHERE wish_completed LIKE :wish_status AND country LIKE :country")
    fun findByStatusAndCountry(wish_status: Boolean, country: String) : List<Wish>

    @Query("UPDATE wish SET wish_completed = :wish_status WHERE uid = :id")
    fun updateStatusById(wish_status: Boolean, id: Int)

    @Query("UPDATE wish SET marked_as_favorite = :wish_mark WHERE uid = :id")
    fun updateMarkById(wish_mark: Boolean, id: Int)

    @Insert
    fun insertAll(vararg wishes: Wish)

    @Delete
    fun delete(wish: Wish)
}