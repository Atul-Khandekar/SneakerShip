package com.example.sneakership.listener

interface ItemClickListener <T> {
    fun onItemClick(item: T, position: Int)
}