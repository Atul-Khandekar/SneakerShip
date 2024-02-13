package com.example.sneakership.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sneakership.R
import com.example.sneakership.adapter.SneakerListAdapter
import com.example.sneakership.databinding.FragmentHomeBinding
import com.example.sneakership.listener.ItemClickListener
import com.example.sneakership.model.local.Sneaker
import com.example.sneakership.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val sneakerListAdapter = SneakerListAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObservers()
    }

    private fun setUpView() {
        binding.rvHome.apply {
            this.adapter = sneakerListAdapter
            setHasFixedSize(true)
        }

        sneakerListAdapter.itemClickListener = object : ItemClickListener<Sneaker> {
            override fun onItemClick(item: Sneaker, position: Int) {
                val destination =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(position)
                findNavController().navigate(destination)
            }

        }

    }

    private fun setUpObservers() {
        viewModel.sneakerList.observe(viewLifecycleOwner) {
            sneakerListAdapter.submitList(it)
        }
    }
}