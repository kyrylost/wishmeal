package com.example.wishmeal.view

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.wishmeal.databinding.WishCardBinding
import com.example.wishmeal.model.Wish

class WishViewHolder (
    private val wishCardBinding: WishCardBinding,
    private val onItemClicked: (position: Int) -> Unit)
    : RecyclerView.ViewHolder(wishCardBinding.root), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    fun bindNote(wish: Wish) {
        wishCardBinding.wishCardText.text = wish.wishText

//        wishCardBinding.wishCardView.setOnClickListener {
//            wishCardBinding.wishCardView.setCardBackgroundColor(
//                Color.parseColor("#B5FFB7")
//            )
//        }
    }

    override fun onClick(v: View) {
        val position = adapterPosition
        onItemClicked(position)
    }
//        wishCardBinding.wishCardView.setOnLongClickListener {
//            wishCardBinding.wishCardView.display.state
//        }
}