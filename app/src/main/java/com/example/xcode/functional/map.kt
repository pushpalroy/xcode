package com.example.xcode.functional

fun main() {

  /**
   * map()
   */

  val list = (1..100).toList()

  val doubled = list.map { item -> item * 2 }
  println(doubled)

  val doubled1 = list.map { it * 2 }
  println(doubled1)

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
  println(flattened)

  val flattened2 = nestedList.map { it.sortedDescending() }
      .flatten()
  println(flattened2)
}
