package com.example.shoppingingredients

inline fun inlineCheck(block:(Int,Int)->Unit){
    block(10,12)
}

fun main(){
    inlineCheck{
            val1,val2->
        print("${val1+val2}")
    }
}