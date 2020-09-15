package com.firmfreez.android.spidergrouptest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.firmfreez.android.spidergrouptest.ui.viewModels.ImagesViewModel
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.adapters.GalleryImagesAdapter
import com.firmfreez.android.spidergrouptest.databinding.FragmentImagesBinding
import com.firmfreez.android.spidergrouptest.utils.GridItemDecoration
import com.firmfreez.android.spidergrouptest.utils.navigate
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Фрагмент отображает список популярных картинок
 */
class ImagesFragment : BaseFragment() {
    private lateinit var binding: FragmentImagesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_images, container, false)
        binding = FragmentImagesBinding.bind(view)
        setToolbar("Популярные", false, binding.root)
        binding.viewModel = ViewModelProvider(this).get(ImagesViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.list.apply {
            layoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
            addItemDecoration(GridItemDecoration(10,3))
//            setHasFixedSize(true)

            binding.viewModel?.let { adapter = GalleryImagesAdapter(it) { link, itemLink ->
                val bundle = bundleOf("url" to link, "realImgUrl" to itemLink)
                navigate(R.id.action_imagesFragment_to_selectedImageFragment, bundle)
            } }
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