package com.example.shoppingingredients

data class Product(val title:String, var price: Double, var amount:Int ) {
    fun discountCount(DiscountValue: Int) {
        if (amount > 0 && amount <= 5) {
            price -= price * DiscountValue / 100
        }
    }
}