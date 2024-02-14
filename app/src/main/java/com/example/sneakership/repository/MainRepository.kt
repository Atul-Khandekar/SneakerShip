package com.example.sneakership.repository

import com.example.sneakership.model.local.Sneaker

class MainRepository {

    fun getSneakerList(): List<Sneaker> {
        val list = mutableListOf<Sneaker>()
        for (i in 1..10) {
            list.addAll(Sneaker.getSneakers())
        }
        return list.toList()
    }
}