package com.firmfreez.android.spidergrouptest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.databinding.ItemCommentBinding
import com.firmfreez.android.spidergrouptest.models.ImageComments
import com.firmfreez.android.spidergrouptest.models.ImageComments.DataItem

class CommentsAdapter: RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {
    private var data: List<DataItem?>? = null

    fun setData(list: List<DataItem?>) {
        data = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comment, parent, false)
        return CommentsViewHolder(ItemCommentBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        data?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    inner class CommentsViewHolder(val binding: ItemCommentBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(comment: DataItem?) {
            binding.author.text = comment?.author
            binding.text.text = comment?.comment
        }
    }
}