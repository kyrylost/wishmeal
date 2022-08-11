package com.example.wishmeal.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.wishmeal.databinding.WishCardBinding
import com.example.wishmeal.model.Wish

class WishAdapter (private val wishes: List<Wish>)
    : RecyclerView.Adapter<WishViewHolder>() {

    lateinit var onItemClickListener : MutableLiveData<Wish>
    lateinit var onItemLongClickListener : MutableLiveData<Wish>

    var allowListeningToItemClick = MutableLiveData<Boolean>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = WishCardBinding.inflate(from, parent, false)

        val wishViewHolder = WishViewHolder(binding)
        onItemClickListener = wishViewHolder.onItemClickListener
        onItemLongClickListener = wishViewHolder.onItemLongClickListener
        allowListeningToItemClick.value = true

        return wishViewHolder
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        holder.bindNote(wishes[position])
    }

    override fun getItemCount(): Int = wishes.size
}