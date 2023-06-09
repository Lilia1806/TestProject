package com.example.testproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.databinding.ItemBinding
import com.example.testproject.presentation.models.FilmUI

class FilmAdapter (
//    val onItemClick: (model: FilmUI) -> Unit
) : ListAdapter<FilmUI, FilmAdapter.AnimeViewHolder>(
    diffUtil
) {

    inner class AnimeViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        init {
//            itemView.setOnClickListener {
//                getItem(absoluteAdapterPosition)?.let { it1 -> onItemClick(it1) }
//            }
//        }

        fun onBind(filmUI: FilmUI) {
            binding.titl.text = filmUI.title
            binding.orTitl.text = filmUI.originalTitle

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FilmUI>() {
            override fun areItemsTheSame(oldItem: FilmUI, newItem: FilmUI): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: FilmUI, newItem: FilmUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}