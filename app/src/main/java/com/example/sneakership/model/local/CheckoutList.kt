package com.example.sneakership.model.local

import java.util.UUID

data class CheckoutList(
    val id: UUID,
    val sneaker: CheckoutSneaker,
    val quantity: Long
)