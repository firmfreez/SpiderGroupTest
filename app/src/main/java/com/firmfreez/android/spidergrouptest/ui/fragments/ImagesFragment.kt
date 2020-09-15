package com.firmfreez.android.spidergrouptest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.firmfreez.android.spidergrouptest.ui.viewModels.ImagesViewModel
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.databinding.FragmentImagesBinding
import com.firmfreez.android.spidergrouptest.utils.navigate

class ImagesFragment : BaseFragment() {
    private lateinit var binding: FragmentImagesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_images, container, false)
        binding = FragmentImagesBinding.bind(view)
        setToolbar("Главный экран", false, binding.root)
        binding.viewModel = ViewModelProvider(this).get(ImagesViewModel::class.java)
        binding.list.layoutManager = StaggeredGridLayoutManager(3,RecyclerView.VERTICAL)
        return binding.root
    }

}