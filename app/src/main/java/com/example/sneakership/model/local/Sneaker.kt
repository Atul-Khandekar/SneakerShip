package com.example.sneakership.model.local

import java.util.UUID

data class Sneaker(
    val id: UUID,
    val brand: String,
    val gender: Gender,
    val images: ArrayList<String>,
    val name: String,
    val price: Long,
) {
    companion object {
        fun getSneakers(): List<Sneaker> {

            return listOf(
                Sneaker(
                    UUID.randomUUID(), "Red Tape", Gender.MALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/61wD8KpKatL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71F9TNZ7lvL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/61LUDhX5BvL._SL1500_.jpg"
                    ), "Red Tape Casual", 1769
                ),

                Sneaker(
                    UUID.randomUUID(), "Asian", Gender.MALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/71cflgAolqL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/81rgoJlkVEL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71ZIz8ZWhsL._SL1500_.jpg"
                    ), "Asian Mens Tarzan", 729
                ),
                Sneaker(
                    UUID.randomUUID(), "Bacca Bucci", Gender.MALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/71V4GGv1edL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/812shEnuYgL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/713WCbImEkL._SL1500_.jpg"
                    ), "Bacca Bucci Balancer ", 1499
                ),
                Sneaker(
                    UUID.randomUUID(), "Asian", Gender.MALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/71N6mH2rA4L._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71V3BgGS3pL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71A0HgM2mhL._SL1500_.jpg"
                    ), "ASIAN Carnival-02", 989
                ),
                Sneaker(
                    UUID.randomUUID(), "U.S POLO ", Gender.MALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/810D7hspHqL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/91NsZltpc+L._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71hIS6sudwL._SL1500_.jpg"
                    ), "POLO Mens Kenna", 2461
                ),
                Sneaker(
                    UUID.randomUUID(), "NIKE", Gender.MALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/71x7NX6Iw-L._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71x7NX6Iw-L._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/71fEkGztddL._SL1500_.jpg"
                    ), "NIKE AIR", 4500
                ),
                Sneaker(
                    UUID.randomUUID(), "NIKE", Gender.FEMALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/41K2X3BxRYL._SL1000_.jpg",
                        "https://m.media-amazon.com/images/I/61ashTX12JL._SL1100_.jpg",
                        "https://m.media-amazon.com/images/I/71NRiwhqPSL._SL1100_.jpg"
                    ), "NIKE Women's Legacy", 5590
                ),
                Sneaker(
                    UUID.randomUUID(), "NIKE", Gender.FEMALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/51SMpyYkfmL._SL1012_.jpg",
                        "https://m.media-amazon.com/images/I/51SMpyYkfmL._SL1012_.jpg",
                        "https://m.media-amazon.com/images/I/51SMpyYkfmL._SL1012_.jpg"
                    ), "NIKE Women's Renew", 4320
                ),

                Sneaker(
                    UUID.randomUUID(), "ADIDAS", Gender.FEMALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/81pkwWsxlFL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/81OSy4TBTtL._SL1500_.jpg",
                        "https://m.media-amazon.com/images/I/81EiTVkcyiL._SL1500_.jpg"
                    ), "Adidas Street Stunner Women", 2450
                ),

                Sneaker(
                    UUID.randomUUID(), "NIKE", Gender.FEMALE, arrayListOf(
                        "https://m.media-amazon.com/images/I/41uA2Z2kzsL._SL1001_.jpg",
                        "https://m.media-amazon.com/images/I/31Bg7w1BqEL._SL1001_.jpg",
                        "https://m.media-amazon.com/images/I/413ICHD3StL._SL1001_.jpg"
                    ), "NIKE Womens WMNS", 7490
                ),

                )
        }
    }
}

enum class Gender {
    MALE, FEMALE
}
