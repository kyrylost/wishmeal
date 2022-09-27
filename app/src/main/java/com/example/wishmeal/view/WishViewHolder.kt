package com.example.wishmeal.view

import android.graphics.Color
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.wishmeal.R
import com.example.wishmeal.databinding.WishCardBinding
import com.example.wishmeal.model.Wish

class WishViewHolder (
    private val wishCardBinding: WishCardBinding,
) : RecyclerView.ViewHolder(wishCardBinding.root) {

    val onItemClickListener = MutableLiveData<Wish>()
    val onItemLongClickListener = MutableLiveData<Wish>()

    val onStarClickListener = MutableLiveData<Wish>()

    fun bindNote(wish: Wish) {
        wishCardBinding.wishCardText.text = wish.wishText
        if (wish.wishCompleted!!) {
            wishCardBinding.wishCardView.setCardBackgroundColor(
                Color.parseColor("#B5FFB7"))

            if (wish.markedAsFavorite!!) {
                wishCardBinding.favoriteIcon.setBackgroundResource(
                    R.drawable.star_icon_clicked)
            }
            else {
                wishCardBinding.favoriteIcon.setBackgroundResource(
                    R.drawable.star_icon)
            }

            wishCardBinding.favoriteIcon.setOnClickListener {
                if (wish.markedAsFavorite) {
                    wishCardBinding.favoriteIcon.setBackgroundResource(
                        R.drawable.star_icon)
                }
                else {
                    wishCardBinding.favoriteIcon.setBackgroundResource(
                        R.drawable.star_icon_clicked)
                }
                onStarClickListener.value = wish
            }
        }

        wishCardBinding.wishCardView.setOnClickListener {
            onItemClickListener.value = wish
        }

        wishCardBinding.wishCardView.setOnLongClickListener {
            onItemLongClickListener.value = wish
            true
        }
    }
}