package com

fun controller(a:Int,b:Int,funDef:(Int,Int)->Int):Int{
    return funDef(a,b)
}
fun myFunc(data1:Int,data2:Int):Int{
   return data1+data2
}
fun myFunc2(data1: Int,data2: Int):Int{
    return data1*data2
}

fun main(){
   val addition= controller(10,12,::myFunc)
   val multiplication= controller(20,30, ::myFunc2)
    print("The Addition result is $addition and Multiplication result is $multiplication")

}
