package com.example.xcode.functional

fun main() {
  val data = listOf(
      mapOf("users1.csv" to listOf(32, 45, 17, -1, 34)),
      mapOf("users2.csv" to listOf(19, -1, 67, 22)),
      mapOf("users3.csv" to listOf()),
      mapOf("users4.csv" to listOf(56, 32, 18, 44))
  )

  val cleaned = data.flatMap { it.values }
      .flatten()
      .filter { it in 1..100 }
      .toIntArray()

  println(cleaned.joinToString())

}