package com.example.shoppingingredients

data class Productt(val name: String, val age: Int)

fun <T:Productt> ProductList(Items:T){
  print(Items.age)
}


fun main() {
   val product = Productt("Mango", 30)
    ProductList(product)
}