package com.example.sneakership.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.core.view.contains
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.sneakership.R
import com.example.sneakership.databinding.ActivityMainBinding
import com.example.sneakership.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView()
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = binding.bottomNavigation
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    private fun setUpView() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.main_menu, menu)
//
//        val menuItem = menu?.findItem(R.id.action_search)
//        val searchView = menuItem?.actionView as SearchView
//        searchView.queryHint = "Search here"
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                viewModel.search(query)
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                viewModel.search(newText)
//                return true
//            }
//
//        })
//
//        return super.onCreateOptionsMenu(menu)
//    }
}