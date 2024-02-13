package com.example.sneakership.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sneakership.model.local.CheckoutList
import com.example.sneakership.model.local.CheckoutSneaker
import com.example.sneakership.model.local.OrderDetails
import com.example.sneakership.repository.MainRepository
import com.example.sneakership.model.local.Sneaker
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _sneakerList = MutableLiveData<List<Sneaker>>(emptyList())
    val sneakerList: LiveData<List<Sneaker>> get() = _sneakerList

    private val list = mutableListOf<CheckoutList>()

    private  val _orderDetails = MutableLiveData<OrderDetails?>(null)

    val orderDetails: LiveData<OrderDetails?> get() = _orderDetails

    private val _checkoutList = MutableLiveData<List<CheckoutList>>(emptyList())
    val checkoutList: LiveData<List<CheckoutList>> get() = _checkoutList

    val map = HashMap<UUID, Int>()


    init {
        getSneakerList()
    }

    private fun getSneakerList() {
        _sneakerList.value = _sneakerList.value?.plus(mainRepository.getSneakerList())
    }

    fun addSneakerToCart(sneaker: Sneaker) {
        val id = sneaker.id

        val checkoutSneaker = CheckoutSneaker(id,sneaker.name,sneaker.price,sneaker.images[0])

        if (map.containsKey(id)) {
            map[id] = map[id]!! + 1
        } else {
            map[id] = 1
        }
        val subTotal = sneaker.price*map[id]!!.toLong()

        map[id]?.let { CheckoutList(id,checkoutSneaker, it.toLong()) }?.let { list.add(it) }
        _checkoutList.value = _checkoutList.value?.plus(
            list
        )

        val subtotal = sneaker.price * map[id]!!
        val tax: Long = 40
        val total = subTotal+tax
        _orderDetails.value = OrderDetails(subtotal,tax,total)

    }

}