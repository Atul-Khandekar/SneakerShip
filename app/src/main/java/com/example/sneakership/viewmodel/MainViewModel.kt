package com.example.sneakership.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sneakership.model.local.CheckoutSneaker
import com.example.sneakership.model.local.OrderDetails
import com.example.sneakership.repository.MainRepository
import com.example.sneakership.model.local.Sneaker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _sneakerList = MutableLiveData<List<Sneaker>>(emptyList())
    val sneakerList: LiveData<List<Sneaker>> get() = _sneakerList

    private val _filteredList = MutableLiveData<List<Sneaker>>(emptyList())
    val filteredList: LiveData<List<Sneaker>> get() = _filteredList

    private val _orderDetails = MutableLiveData<OrderDetails?>(null)

    val orderDetails: LiveData<OrderDetails?> get() = _orderDetails

    private val _checkoutList = MutableLiveData<List<CheckoutSneaker>>(emptyList())
    val checkoutList: LiveData<List<CheckoutSneaker>> get() = _checkoutList

    var hasSetActionBar = false

    private val _cartSize = MutableLiveData<Int>(0)
    val cartSize: LiveData<Int> get() = _cartSize

    init {
        getSneakerList()
    }

    private fun getSneakerList() {
        _sneakerList.value = _sneakerList.value?.plus(mainRepository.getSneakerList())
        _filteredList.value = _sneakerList.value
    }

    fun addSneakerToCart(sneaker: Sneaker) {
        _checkoutList.value = _checkoutList.value?.plus(
            CheckoutSneaker(sneaker.id, sneaker.name, sneaker.price, sneaker.images[0])
        )

        val subtotal = _checkoutList.value?.sumOf { it.price }
        val tax = 40.toLong()
        subtotal?.let {
            _orderDetails.value = OrderDetails(subtotal, tax, subtotal + tax)
        }

        incrementCartSize()
    }

    fun removeSneakerFromCart(position: Int) {
        _checkoutList.value = _checkoutList.value?.minus(
            _checkoutList.value?.get(position)!!
        )
        val subtotal = _checkoutList.value?.sumOf { it.price }
        var tax: Long
        if (subtotal == 0.toLong()) {
            tax = 0
        } else {
            tax = 40
        }

        subtotal?.let {
            _orderDetails.value = OrderDetails(subtotal, tax, subtotal + tax)
        }

        decrementCartSize()
    }

    fun search(key: String?) {
        if (key.isNullOrEmpty()) {
            _filteredList.value = _sneakerList.value
        } else {

            _filteredList.value = _sneakerList.value?.filter {
                it.name.contains(key, true)
            }
        }

    }

    private fun incrementCartSize() {
        _cartSize.value = _cartSize.value?.plus(1)
    }

    private fun decrementCartSize() {
        _cartSize.value = _cartSize.value?.minus(1)
    }

}