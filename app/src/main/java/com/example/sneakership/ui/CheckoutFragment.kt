package com.example.sneakership.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.sneakership.BR
import com.example.sneakership.R
import com.example.sneakership.adapter.CheckoutAdapter
import com.example.sneakership.databinding.FragmentCheckoutBinding
import com.example.sneakership.listener.ItemClickListener
import com.example.sneakership.model.local.CheckoutSneaker
import com.example.sneakership.viewmodel.MainViewModel

class CheckoutFragment : Fragment() {

    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private val checkoutListAdapter = CheckoutAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckoutBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
        setUpObservers()
        setUpClickListeners()
    }

    private fun setUpClickListeners() {
        checkoutListAdapter.btnClickListener = object : ItemClickListener<CheckoutSneaker> {
            override fun onItemClick(item: CheckoutSneaker, position: Int) {
                viewModel.removeSneakerFromCart(position)
            }
        }

        binding.apply {
            toolBar.setNavigationOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        }
    }

    private fun setUpView() {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.apply {
            rvCheckout.apply {
                this.adapter = checkoutListAdapter
                setHasFixedSize(true)
            }
        }
    }

    private fun setUpObservers() {
        viewModel.checkoutList.observe(viewLifecycleOwner) {
            checkoutListAdapter.submitList(it)
        }

        viewModel.orderDetails.observe(viewLifecycleOwner) {
            binding.setVariable(BR.item, it)
            binding.executePendingBindings()
        }
    }

}