package com.example.sneakership.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.sneakership.adapter.ImageSlideAdapter
import com.example.sneakership.databinding.FragmentDetailBinding
import com.example.sneakership.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var viewModel: MainViewModel
    private lateinit var viewPagerAdapter: ImageSlideAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpNavigationBar()
        setUpClickListeners()

    }

    private fun setUpNavigationBar() {
        binding.apply {
            toolBar.setNavigationOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun setUpClickListeners() {
        binding.apply {
            btnCheckout.setOnClickListener {
                viewModel.addSneakerToCart(viewModel.sneakerList.value!![args.position])
            }
        }
    }

    private fun setUpView() {

        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val item = viewModel.sneakerList.value?.get(args.position)
        val price = item?.price

        item?.images?.let {
            viewPagerAdapter = ImageSlideAdapter(requireContext(), it)
        }

        binding.apply {
            viewPager.adapter = viewPagerAdapter
            dotIndicator.attachTo(viewPager)
            detailPrice.text = price.toString()
            productTitle.text = item?.name
        }
    }
}