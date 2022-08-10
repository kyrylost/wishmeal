package com.example.wishmeal.viewmodel

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel(){

    private var unvisitedSelected = true
    var unvisitedColorChanged = MutableLiveData<Int>()

    private var visitedSelected = false
    var visitedColorChanged = MutableLiveData<Int>()

    private var allCuisinesSelected = true
    var allCuisinesColorChanged = MutableLiveData<Int>()

    private var ukrainianCuisineSelected = false
    var ukrainianCuisineColorChanged = MutableLiveData<Int>()

    private var europeanCuisineSelected = false
    var europeanCuisineColorChanged = MutableLiveData<Int>()

    private var americanCuisineSelected = false
    var americanCuisineColorChanged = MutableLiveData<Int>()

    private var asianCuisineSelected = false
    var asianCuisineColorChanged = MutableLiveData<Int>()

    var refreshWishlist = MutableLiveData<Boolean>()

    fun unvisitedOnClick() {
        viewModelScope.launch {
            if (!unvisitedSelected) {
                unvisitedSelected = true
                visitedSelected = false
                refreshWishlist.value = true
                unvisitedColorChanged.value = (Color.parseColor("#FFFFC23C"))
                visitedColorChanged.value = (Color.parseColor("#FF000000"))
            }
        }
    }

    fun visitedOnClick() {
        viewModelScope.launch {
            if (!visitedSelected) {
                visitedSelected = true
                unvisitedSelected = false
                refreshWishlist.value = true
                visitedColorChanged.value = (Color.parseColor("#FFFFC23C"))
                unvisitedColorChanged.value = (Color.parseColor("#FF000000"))
            }
        }
    }

    fun allCuisinesOnClick() {
        viewModelScope.launch {
            if (!allCuisinesSelected) {
                allCuisinesSelected = true
                allCuisinesColorChanged.value = (Color.parseColor("#FFFFC23C"))

                if (ukrainianCuisineSelected) {
                    ukrainianCuisineSelected = false
                    ukrainianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (europeanCuisineSelected) {
                    europeanCuisineSelected = false
                    europeanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (americanCuisineSelected) {
                    americanCuisineSelected = false
                    americanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (asianCuisineSelected) {
                    asianCuisineSelected = false
                    asianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                refreshWishlist.value = true
            }
        }
    }

    fun ukrainianCuisineOnClick() {
        viewModelScope.launch {
            if (!ukrainianCuisineSelected) {
                ukrainianCuisineSelected = true
                ukrainianCuisineColorChanged.value = (Color.parseColor("#FFFFC23C"))

                if (allCuisinesSelected) {
                    allCuisinesSelected = false
                    allCuisinesColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (europeanCuisineSelected) {
                    europeanCuisineSelected = false
                    europeanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (americanCuisineSelected) {
                    americanCuisineSelected = false
                    americanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (asianCuisineSelected) {
                    asianCuisineSelected = false
                    asianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                refreshWishlist.value = true
            }
        }
    }

    fun europeanCuisineOnClick() {
        viewModelScope.launch {
            if (!europeanCuisineSelected) {
                europeanCuisineSelected = true
                europeanCuisineColorChanged.value = (Color.parseColor("#FFFFC23C"))

                if (allCuisinesSelected) {
                    allCuisinesSelected = false
                    allCuisinesColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (ukrainianCuisineSelected) {
                    ukrainianCuisineSelected = false
                    ukrainianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (americanCuisineSelected) {
                    americanCuisineSelected = false
                    americanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (asianCuisineSelected) {
                    asianCuisineSelected = false
                    asianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                refreshWishlist.value = true
            }
        }
    }

    fun americanCuisineOnClick() {
        viewModelScope.launch {
            if (!americanCuisineSelected) {
                americanCuisineSelected = true
                americanCuisineColorChanged.value = (Color.parseColor("#FFFFC23C"))

                if (allCuisinesSelected) {
                    allCuisinesSelected = false
                    allCuisinesColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (ukrainianCuisineSelected) {
                    ukrainianCuisineSelected = false
                    ukrainianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (europeanCuisineSelected) {
                    europeanCuisineSelected = false
                    europeanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (asianCuisineSelected) {
                    asianCuisineSelected = false
                    asianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                refreshWishlist.value = true
            }
        }
    }

    fun englandCuisineOnClick() {
        viewModelScope.launch {
            if (!asianCuisineSelected) {
                asianCuisineSelected = true
                asianCuisineColorChanged.value = (Color.parseColor("#FFFFC23C"))

                if (allCuisinesSelected) {
                    allCuisinesSelected = false
                    allCuisinesColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (ukrainianCuisineSelected) {
                    ukrainianCuisineSelected = false
                    ukrainianCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (europeanCuisineSelected) {
                    europeanCuisineSelected = false
                    europeanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                if (americanCuisineSelected) {
                    americanCuisineSelected = false
                    americanCuisineColorChanged.value = (Color.parseColor("#FF000000"))
                }

                refreshWishlist.value = true
            }
        }
    }

    fun currentStatus(): Boolean {
        return !unvisitedSelected
    }

    fun currentCountry(): String {
        if(ukrainianCuisineSelected) return "ukrainian"
        if(europeanCuisineSelected) return "european"
        if(americanCuisineSelected) return "american"
        if(asianCuisineSelected) return "asian"
        return "other"
    }

}