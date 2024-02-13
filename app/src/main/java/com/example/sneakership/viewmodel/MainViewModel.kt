package com.example.sneakership.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sneakership.repository.MainRepository
import com.example.sneakership.model.local.Sneaker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _sneakerList = MutableLiveData<List<Sneaker>>(emptyList())
    val sneakerList: LiveData<List<Sneaker>> get() = _sneakerList

    private val _checkoutList = MutableLiveData<List<Sneaker>>(emptyList())
    val checkoutList: LiveData<List<Sneaker>> get() = _checkoutList

    init {
        getSneakerList()
    }

    private fun getSneakerList() {
        _sneakerList.value = _sneakerList.value?.plus(mainRepository.getSneakerList())
    }

}