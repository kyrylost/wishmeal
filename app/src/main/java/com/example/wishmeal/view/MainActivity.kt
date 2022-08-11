package com.example.wishmeal.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wishmeal.R
import com.example.wishmeal.databinding.ActivityMainBinding
import com.example.wishmeal.model.Wish
import com.example.wishmeal.viewmodel.AppViewModel
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var appViewModel : AppViewModel
    lateinit var wishes : List<Wish>

//    private fun onListItemClick(position: Int) {
//        Toast.makeText(this, wishes[position].wishText, Toast.LENGTH_SHORT).show()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        appViewModel = ViewModelProvider(this)[AppViewModel::class.java]
        appViewModel.getInstance(applicationContext)

        appViewModel.wishesLiveData.observe(this) { wishList ->

            Log.d("wishList", wishList.toString())

            binding.wishes.apply {
                val wishAdapter = WishAdapter(wishList)
                layoutManager = GridLayoutManager(applicationContext, 1)
                adapter = wishAdapter

                wishAdapter.allowListeningToItemClick.observe(this@MainActivity) {

                    wishAdapter.onItemClickListener.observe(this@MainActivity) { wish->
                        appViewModel.updateStatusById(wish)
                    }
                    wishAdapter.onItemLongClickListener.observe(this@MainActivity) {
                        // Edit wish
                    }

                }

            }
        }

        appViewModel.categoryViewModel.refreshWishlist.observe(this) {
            appViewModel.getWishesFilteredByStatusAndCountry()
        }

        appViewModel.categoryViewModel.unvisitedColorChanged.observe(this) { color->
            binding.unvisitedTextView.setTextColor(color)
        }
        appViewModel.categoryViewModel.visitedColorChanged.observe(this) { color->
            binding.visitedTextView.setTextColor(color)
        }

        appViewModel.categoryViewModel.allCuisinesColorChanged.observe(this) { color->
            binding.allTextView.setTextColor(color)
        }
        appViewModel.categoryViewModel.ukrainianCuisineColorChanged.observe(this) { color->
            binding.ukrainianTextView.setTextColor(color)
        }
        appViewModel.categoryViewModel.europeanCuisineColorChanged.observe(this) { color->
            binding.europeanTextView.setTextColor(color)
        }
        appViewModel.categoryViewModel.americanCuisineColorChanged.observe(this) { color->
            binding.americanTextView.setTextColor(color)
        }
        appViewModel.categoryViewModel.asianCuisineColorChanged.observe(this) { color->
            binding.asianTextView.setTextColor(color)
        }

        binding.addNewWishBtn.setOnClickListener{
            val newWishPopup = layoutInflater.inflate(R.layout.add_new, null)

            val dialogBuilderNewWish = AlertDialog.Builder(this)
            dialogBuilderNewWish.setView(newWishPopup)
            val dialogNewWish = dialogBuilderNewWish.create()
            dialogNewWish.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialogNewWish.show()

            val addWishPopupBtn =
                dialogNewWish.findViewById<Button>(R.id.addWishPopupBtn)
            val newWishTextEdit =
                dialogNewWish.findViewById<TextInputEditText>(R.id.newWishTextEdit)
            val cuisineSpinner =
                dialogNewWish.findViewById<Spinner>(R.id.cuisineSpinner)

            val cuisine = resources.getStringArray(R.array.cuisine)
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, cuisine)
            cuisineSpinner?.adapter = adapter

            addWishPopupBtn?.setOnClickListener{
                val wishText = newWishTextEdit?.text.toString()

                var country = ""
                when(cuisineSpinner?.selectedItemId?.toInt()) {
                    0 -> country = "other"
                    1 -> country = "ukrainian"
                    2 -> country = "european"
                    3 -> country = "american"
                    4 -> country = "asian"
                }

                if(wishText.isNotEmpty()) {
                    val wish = Wish(
                        uid = appViewModel.wishAmount,
                        wishText = wishText,
                        country = country,
                        wishCompleted = false
                    )
                    appViewModel.insertNewWish(wish)
                    dialogNewWish.dismiss()
                }
            }
        }

        binding.unvisitedTextView.setOnClickListener{
            appViewModel.categoryViewModel.unvisitedOnClick()
        }
        binding.visitedTextView.setOnClickListener{
            appViewModel.categoryViewModel.visitedOnClick()
        }

        binding.allTextView.setOnClickListener{
            appViewModel.categoryViewModel.allCuisinesOnClick()
        }
        binding.ukrainianTextView.setOnClickListener{
            appViewModel.categoryViewModel.ukrainianCuisineOnClick()
        }
        binding.europeanTextView.setOnClickListener{
            appViewModel.categoryViewModel.europeanCuisineOnClick()
        }
        binding.americanTextView.setOnClickListener{
            appViewModel.categoryViewModel.americanCuisineOnClick()
        }
        binding.asianTextView.setOnClickListener{
            appViewModel.categoryViewModel.englandCuisineOnClick()
        }

    }
}