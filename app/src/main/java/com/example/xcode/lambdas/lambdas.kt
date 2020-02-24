package com.example.xcode.lambdas

fun main() {

    /**
     * lambdas
     */

    val timesTwo: (Int) -> Int = { x: Int -> x * 2 }

    val addTwoNumbers: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    val _timesTwo = { x: Int -> x * 2 }

    val _addTwoNumbers = { x: Int, y: Int -> x + y }

    val list = (1..100).toList()

    val filteredList1 = list.filter { item -> item % 2 == 0 }

    val filteredList2 = list.filter { it % 2 == 0 }

    val filteredList3 = list.filter(::isEven)

    val filteredList4 = list.filter { it.even() }

    println(filteredList3)
}

fun isEven(i: Int) = i % 2 == 0

fun Int.even() = this % 2 == 0