package com.example.sneakership.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpSearchView()
        setUpClickListeners()
        setUpObservers()
    }

    private fun setUpSearchView() {

        if (!viewModel.hasSetActionBar) {
            (requireActivity() as AppCompatActivity).setSupportActionBar(binding.appBar)
            viewModel.hasSetActionBar = true
        }

        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
                val menuItem = menu.findItem(R.id.action_search)
                val searchView = menuItem.actionView as SearchView
                searchView.queryHint = "Search Here"

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        viewModel.search(query)
                        return true
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        viewModel.search(newText)
                        return true
                    }

                })

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return true
            }

        })
    }

    private fun setUpClickListeners() {
        sneakerListAdapter.itemClickListener = object : ItemClickListener<Sneaker> {
            override fun onItemClick(item: Sneaker, position: Int) {
                val destination =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(position)
                findNavController().navigate(destination)
            }

        }

        sneakerListAdapter.btnClickListener = object : ItemClickListener<Sneaker> {
            override fun onItemClick(item: Sneaker, position: Int) {
                viewModel.addSneakerToCart(item)
            }
        }
    }

    private fun setUpView() {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding.rvHome.apply {
            this.adapter = sneakerListAdapter
            setHasFixedSize(true)
        }
    }

    private fun setUpObservers() {
        viewModel.filteredList.observe(viewLifecycleOwner) {
            sneakerListAdapter.submitList(it)
        }
    }
}