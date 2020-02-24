package com.example.xcode.lambdas

fun main() {

    // Generate a lazy collection infinite list
    val list = generateSequence(0) { it + 10 }

    // Take first 10 items
    val firstTenItems = list.take(10).toList()

    // Take first 20 items after executing above
    val firstTwentyItems = list.take(20).toList()

    println(firstTenItems)

    println(firstTwentyItems)

    val dropFirstTenItems = list.drop(5).toList()

    println(dropFirstTenItems)
}