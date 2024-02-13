package com.example.sneakership.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sneakership.R
import com.example.sneakership.adapter.SneakerListAdapter
import com.example.sneakership.databinding.FragmentHomeBinding
import com.example.sneakership.model.local.Sneaker


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val sneakerListAdapter = SneakerListAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHome.apply {
            this.adapter = sneakerListAdapter
            setHasFixedSize(true)
            sneakerListAdapter.submitList(Sneaker.getSneakers())

        }
    }
}