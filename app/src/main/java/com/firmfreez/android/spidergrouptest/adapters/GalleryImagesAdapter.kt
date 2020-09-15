package com.firmfreez.android.spidergrouptest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.databinding.ItemGalleryImageBinding
import com.firmfreez.android.spidergrouptest.models.GalleryItems.*

class GalleryImagesAdapter: PagingDataAdapter<DataItem, GalleryImagesAdapter.GalleryImagesViewHolder>(ImageComparator) {

    override fun onBindViewHolder(holder: GalleryImagesViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImagesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery_image, parent, false)
        val binding = ItemGalleryImageBinding.bind(view)
        return GalleryImagesViewHolder(binding)
    }

    inner class GalleryImagesViewHolder(val binding: ItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataItem) {
            binding.textView.text = item.id
        }
    }

    object ImageComparator : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(
            oldItem: DataItem,
            newItem: DataItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataItem,
            newItem: DataItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}