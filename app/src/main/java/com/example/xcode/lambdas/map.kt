package com.example.xcode.lambdas

fun main() {

    /**
     * map()
     */

    val list = (1..100).toList()

    val doubled = list.map { item -> item * 2 }

    val _doubled = list.map { it * 2 }

    println(doubled)

    val average = list.average()

    val shifted = list.map { it - average }

    println(shifted)

    /**
     * flatMap()
     */

    val nestedList = listOf(
        (1..10).toList(),
        (11..20).toList(),
        (21..30).toList()
    )

    val notFlattened = nestedList.map { it.sortedDescending() }

    println(notFlattened)

    val flattened = nestedList.flatMap { it.sortedDescending() }

    val flattened2 = nestedList.map { it.sortedDescending() }.flatten()

    println(flattened)
}
