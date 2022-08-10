package com.example.wishmeal.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wishmeal.databinding.WishCardBinding
import com.example.wishmeal.model.Wish

class WishAdapter (private val wishes: List<Wish>,
                   private val onItemClicked: (position: Int) -> Unit)
    : RecyclerView.Adapter<WishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = WishCardBinding.inflate(from, parent, false)
        return WishViewHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        holder.bindNote(wishes[position])
    }

    override fun getItemCount(): Int = wishes.size

//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener {
//                onItemClick?.invoke(wishes[adapterPosition])
//            }
//        }
//    }
}