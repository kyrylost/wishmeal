package com.example.wishmeal.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.wishmeal.model.AppDatabase
import com.example.wishmeal.model.Wish
import com.example.wishmeal.model.WishDao
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppViewModel : ViewModel(){
    lateinit var db: AppDatabase
    lateinit var wishDao: WishDao
    var wishAmount = -1
    val wishesLiveData = MutableLiveData<List<Wish>>()

    val categoryViewModel = CategoryViewModel()

    @OptIn(DelicateCoroutinesApi::class)
    fun getInstance(context: Context) {
        GlobalScope.launch {

//            val MIGRATION_2_3 = object : Migration(2, 3) {
//                override fun migrate(database: SupportSQLiteDatabase) {
//
//                    database.execSQL(
//                        "ALTER TABLE Wish ADD COLUMN marked_as_favorite INTEGER DEFAULT 0")
//                }
//            }

            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, "database-name"
            ).build()



            wishDao = db.wishDao()
            wishesLiveData.postValue(wishDao.findByStatus(false))

            val allWishes = wishDao.getAll()
            wishAmount = allWishes.count()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun getWishesFilteredByStatusAndCountry() {
        GlobalScope.launch {
            if (categoryViewModel.currentCountry() == "other") {
                wishesLiveData.postValue(
                    wishDao.findByStatus(categoryViewModel.currentStatus())
                )
            }
            else {
                wishesLiveData.postValue(
                    wishDao.findByStatusAndCountry(
                        categoryViewModel.currentStatus(),
                        categoryViewModel.currentCountry()
                    )
                )
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun updateStatusById(wish: Wish) {
        GlobalScope.launch {
            val status = !wish.wishCompleted!!
            val id = wish.uid
            wishDao.updateStatusById(status, id).apply {
                getWishesFilteredByStatusAndCountry()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insertNewWish(wish: Wish) {
        GlobalScope.launch {
            wishAmount++
            wishDao.insertAll(wish).apply {
                getWishesFilteredByStatusAndCountry()
            }
        }
    }

}