package com.firmfreez.android.spidergrouptest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.databinding.ItemGalleryImageBinding
import com.firmfreez.android.spidergrouptest.models.GalleryItems.*
import com.firmfreez.android.spidergrouptest.ui.viewModels.ImagesViewModel
import com.firmfreez.android.spidergrouptest.utils.toImgurUrl
import kotlin.math.roundToInt

class GalleryImagesAdapter(private val viewModel: ImagesViewModel, private val onItemClicked: (id: String, realId: String) -> Unit): PagingDataAdapter<ImagesItem, GalleryImagesAdapter.GalleryImagesViewHolder>(ImageComparator) {

    override fun onBindViewHolder(holder: GalleryImagesViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImagesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery_image, parent, false)
        val binding = ItemGalleryImageBinding.bind(view)
        return GalleryImagesViewHolder(binding)
    }

    inner class GalleryImagesViewHolder(private val binding: ItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImagesItem) {
            val itemLink: String = item.link ?: ""
            binding.root.setOnClickListener { item.id?.let { onItemClicked(it, itemLink) } }

            val coaf = (item.height?.toDouble()?: 0.0) / (item.width?.toDouble()?: 0.1)

            val width = binding.root.width

            val newHeight = width  * coaf
            if(newHeight != 0.0) {
                binding.image.layoutParams.height = newHeight.roundToInt()
                binding.image.requestLayout()
            }

            Glide.with(binding.image)
                .load(item.link?.toImgurUrl(false))
                .placeholder(R.color.colorAccent)
                .error(R.color.colorPrimaryDark)
                .into(binding.image)
        }
    }

    object ImageComparator : DiffUtil.ItemCallback<ImagesItem>() {
        override fun areItemsTheSame(
            oldItem: ImagesItem,
            newItem: ImagesItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ImagesItem,
            newItem: ImagesItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}