package com.example.shoppingingredients

class collectionOfProduct{
    fun collectedData(data:(Int,String)->Unit){
        data(344,"saikat")
    }

}

fun main(){
    collectionOfProduct().collectedData{roll,name->

        print( "the name is ${name} and the roll is ${roll}")


    }
}
