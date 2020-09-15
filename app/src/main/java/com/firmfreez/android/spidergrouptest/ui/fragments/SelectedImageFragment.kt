package com.firmfreez.android.spidergrouptest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.adapters.CommentsAdapter
import com.firmfreez.android.spidergrouptest.databinding.FragmentSelectedImageBinding
import com.firmfreez.android.spidergrouptest.ui.viewModels.SelectedImageViewModel
import com.firmfreez.android.spidergrouptest.utils.toImgurUrl

/**
 * Фрагемент, отображающий фотографию, название, описание и список комметариев
 * Вызывается по клику на элемент из GalleryImagesAdapter
 */
class SelectedImageFragment : BaseFragment() {
    private lateinit var binding: FragmentSelectedImageBinding
    private lateinit var id: String
    private lateinit var realImgId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selected_image, container, false)
        binding = FragmentSelectedImageBinding.bind(view)
        binding.lifecycleOwner = this

        setToolbar("Подробнее", true, binding.root)

        id = arguments?.getString(ITEM_ID)?: "cJp4uY6"
        realImgId = arguments?.getString(REAL_IMG_URL)?: "8u3skSq"
        binding.viewModel = ViewModelProvider(this, SelectedImageViewModel.Factory(id)).get(SelectedImageViewModel::class.java)

        Log.d("KEK", id)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(binding.image)
            .load(realImgId.toImgurUrl(true))
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.image)

        binding.comments.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = CommentsAdapter()
        }
        binding.viewModel?.commentsLiveData?.observe(viewLifecycleOwner) {
            (binding.comments.adapter as? CommentsAdapter)?.setData(it)
        }
    }

    companion object {
        //id объекта изображения
        const val ITEM_ID = "url"
        //id самой картинки
        const val REAL_IMG_URL = "realImgUrl"
    }

}