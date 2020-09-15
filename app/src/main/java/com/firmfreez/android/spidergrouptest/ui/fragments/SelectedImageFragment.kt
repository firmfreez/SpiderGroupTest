package com.firmfreez.android.spidergrouptest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.firmfreez.android.spidergrouptest.R
import com.firmfreez.android.spidergrouptest.databinding.FragmentSelectedImageBinding
import com.firmfreez.android.spidergrouptest.ui.viewModels.SelectedImageViewModel

class SelectedImageFragment : BaseFragment() {
    private lateinit var binding: FragmentSelectedImageBinding
    private var id: String? = null

    fun newInstance(id: String): SelectedImageFragment{
        val args = Bundle()
        args.putString(id, ITEM_ID)
        val fragment = SelectedImageFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_selected_image, container, false)
        binding = FragmentSelectedImageBinding.bind(view)
        setToolbar("Следующий фрагмент", true, binding.root)
        binding.viewModel = ViewModelProvider(this).get(SelectedImageViewModel::class.java)

        id = arguments?.getString(ITEM_ID)
        binding.textView.text = id

        return binding.root
    }

    companion object {
        const val ITEM_ID = "url"
    }
}