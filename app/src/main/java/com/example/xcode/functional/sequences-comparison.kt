package com.example.xcode.functional

import kotlin.system.measureTimeMillis

fun main() {

  var sum = 0L
  var lazySum = 0L

  val veryLongList = (1..999999L).toList()

  val collectionTime = measureTimeMillis {
    sum = veryLongList
        .filter { it > 10 }
        .map { it * 3 }
        .take(1000)
        .sum()
  }

  val lazyTime = measureTimeMillis {
    lazySum = veryLongList
        .asSequence()
        .filter { it > 10 }
        .map { it * 3 }
        .take(1000)
        .sum()
  }

  println("Collection: Time: $collectionTime ms, Sum: $sum")
  println("Lazy: Time: $lazyTime ms, Sum: $lazySum")
}