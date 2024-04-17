package com.example.shoppingingredients
//
//Introduction to the fold function
//The fold collection processing function is used to accumulate a value starting from an initial value and applying an operation to the accumulated value and each element from left to right. You may use the fold function to calculate the order total by summing up the number of individual items in a cart or to multiply a list of numbers and so forth.
//
//The fold function
//Definition
//12345
//inline fun <T, R> Iterable<T>.fold(
//    initial: R,
//    operation: (acc: R, T) -> R
//): R
//
//The ‘fold’ function is defined as an extension function on the interface ‘Iterable’. To recap, ‘Iterable’ is an interface that is inherited by the ‘Collection’ interface and therefore by all collections such as ‘List’, ‘Set’ etc. too. It means that for an object of type ‘Iterable’, its elements can be represented as a sequence that can be iterated over.
//
//The ‘fold’ function takes in two parameters:
//
//Initial value – This is used as the initial accumulator value.
//
//Operation function type – This is a lambda expression block with the current accumulator value and each element. It contains the operation logic on the current accumulator value and the element’s value. The operation’s result becomes the new accumulator value.
//
//Example
//Let’s say a customer of Little Lemon has a few items in the shopping cart. In this example, you need to use the ‘fold’ function to get the total order amount of the shopping cart. Let’s define a data class OrderItem as:
//
//12345
//data class OrderItem(
//    val name: String,
//    val amount: Int,
//    val quantity: Int
//)
//Let’s define a list of sample order items:
//
//12345
//val orderItemList = listOf(
//    OrderItem("Burger", 6, 2),
//    OrderItem("Fries", 2, 1),
//    OrderItem("Soda", 3, 3)
//)
//Now, calculate the total order amount using the fold function as:
//
//12345
//val totalAmount = orderItemList.fold(0) { totalOrderAmount, orderItem ->
//    totalOrderAmount + (orderItem.amount * orderItem.quantity)
//}
//
//println(totalAmount) // This will print 23
//Note that the fold function was passed 0 as the initial value, as the order amount for no items would be 0.
//class dataCollector{
//   fun dataStorage( data:List<Int>):List<Int>{
//        return data
//
//    }
//}
//fun main() {
//
//    val collectData = dataCollector().dataStorage(listOf(12, 23, 45))
//    val dataStorage = collectData.fold(10) { accumulator, data ->
//        accumulator * data
//
//    }
//    println("Before:- ${collectData}")
//    print("After:- ${dataStorage}")
//}

fun main(){

    val setOfData:List<Int> = listOf(11,22,33,12,23,45,11,11,33)
    val mutableSetData=setOfData.fold(mutableSetOf<Int>()){
        acc,data->
            acc.apply{
                add(data)

    }
    }
    print("This is the mutable List -> ${mutableSetData}")
}