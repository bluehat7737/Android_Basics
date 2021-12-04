package com.example.kotlinbasics

import kotlin.reflect.typeOf

fun main(args: Array<String>) {
//    Sets
//    var fruits = setOf("Orange", "Apple", "Mango", "Mango")
//    print(fruits.size)
     var daysOfTheWeek = mapOf(1 to "Monday", 2 to "Tuesday", 3 to "Wednesday")
     print(daysOfTheWeek[0])

     for(key in daysOfTheWeek.keys){
          println("$key is connected to ${daysOfTheWeek[key]}")
     }
//     var fruit = Fruits("Apple", 1.0)
     var fruitMap = mapOf(1 to Fruits("Mango", 5.25), 2 to Fruits("Orange", 3.27))
}

data class Fruits(var name:String, var price:Double)