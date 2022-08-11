package com.example.wishmeal.view

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.wishmeal.databinding.WishCardBinding
import com.example.wishmeal.model.Wish

class WishViewHolder (
    private val wishCardBinding: WishCardBinding,
) : RecyclerView.ViewHolder(wishCardBinding.root) {

    val onItemClickListener = MutableLiveData<Wish>()
    val onItemLongClickListener = MutableLiveData<Wish>()

    fun bindNote(wish: Wish) {
        wishCardBinding.wishCardText.text = wish.wishText
        if (wish.wishCompleted == true) {
            wishCardBinding.wishCardView.setCardBackgroundColor(
                Color.parseColor("#B5FFB7"))
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