package com.example.sneakership.repository

import com.example.sneakership.model.local.Sneaker

class MainRepository {

    fun getSneakerList() = Sneaker.getSneakers()
}