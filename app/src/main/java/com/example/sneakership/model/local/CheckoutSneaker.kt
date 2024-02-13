package com.example.sneakership.model.local

import java.util.UUID

data class CheckoutSneaker(val id: UUID, val name: String, val price: Long, val image: String)