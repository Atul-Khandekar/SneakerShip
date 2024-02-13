package com.example.sneakership.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.PagerAdapter
import com.example.sneakership.R
import com.example.sneakership.adapter.ImageSlideAdapter
import com.example.sneakership.databinding.FragmentDetailBinding
import com.example.sneakership.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: MainViewModel by viewModels()
    private lateinit var viewPagerAdapter: ImageSlideAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {

        val item = viewModel.sneakerList.value?.get(args.position)

        item?.images?.let{
            viewPagerAdapter = ImageSlideAdapter(requireContext(),it)
        }

        binding.apply {
            viewPager.adapter = viewPagerAdapter
            dotIndicator.attachTo(viewPager)
        }
    }

}