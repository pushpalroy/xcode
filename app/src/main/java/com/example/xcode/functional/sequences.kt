package com.example.xcode.functional

fun main() {

  val veryLongList = (1..999999L).toList()

  /**
   * Converting a very long list to a lazy sequence which will evaluate lazily
   * Only those function calls are evaluated which are actually needed
   * */

  val sum = veryLongList
      .asSequence()
      .filter { it > 50 }
      .map { it * 2 }
      .take(1000)
      .sum()

  println(sum)

  /**
   * Generate a sequence of odd numbers
   * */

  val sequence = generateSequence(1, { it + 2 })

  println(sequence.take(10).toList())
}