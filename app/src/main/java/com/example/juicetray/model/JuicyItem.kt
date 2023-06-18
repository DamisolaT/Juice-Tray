package com.example.juicetray.model

import java.text.NumberFormat

class JuicyItem (
    val name: String,
    val description: String,
    val price:Double,
    val type: Int
) {
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}

