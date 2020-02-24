package com.example.xcode.lambdas

fun main() {

    val list = listOf("this", "is", "zip", "operation")

    val containsT = listOf(true, false, false, true)

    val zipped: List<Pair<String, Boolean>> = list.zip(containsT)

    val mapping = list.zip(list.map { it.contains("t") })

    println(zipped)

    println(mapping)
}