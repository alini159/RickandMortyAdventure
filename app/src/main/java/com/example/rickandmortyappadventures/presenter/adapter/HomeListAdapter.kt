package com.example.rickandmortyappadventures.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.rickandmortyappadventures.databinding.ItemListCharacterBinding
import com.example.rickandmortyappadventures.domain.model.Personage

class HomeListAdapter(var onClick: (personage: Personage) -> Unit = {}) :
    PagingDataAdapter<Personage, HomeListAdapter.ViewHolder>(DiffCallBack()) {
    inner class ViewHolder(val binding: ItemListCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(personage: Personage) {
            Glide.with(itemView)
                .load(personage.image)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.image)

            binding.apply {
                name.text = personage.name.toString()
                specie.text = personage.species.toString()
                origin.text = personage.origin?.name?.split(" ")?.first()
                toDetailsButton.setOnClickListener { onClick.invoke(personage) }
            }
        }
    }

    class DiffCallBack() : DiffUtil.ItemCallback<Personage>() {
        override fun areItemsTheSame(oldItem: Personage, newItem: Personage): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Personage, newItem: Personage): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(
        ItemListCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}