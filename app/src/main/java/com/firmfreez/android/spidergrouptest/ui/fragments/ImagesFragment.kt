package com.firmfreez.android.spidergrouptest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.firmfreez.android.spidergrouptest.ui.viewModels.ImagesViewModel
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.adapters.GalleryImagesAdapter
import com.firmfreez.android.spidergrouptest.databinding.FragmentImagesBinding
import com.firmfreez.android.spidergrouptest.utils.navigate
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.list.apply {
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
            setHasFixedSize(true)
            adapter = GalleryImagesAdapter()
        }

        initAdapter()
    }

    private fun initAdapter() {
        lifecycleScope.launch {
            binding.viewModel?.movies?.collectLatest {
                (binding.list.adapter as? GalleryImagesAdapter)?.submitData(it)
            }
        }
    }
}