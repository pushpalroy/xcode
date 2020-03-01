package com.example.xcode.lambdas

import kotlin.math.roundToInt

fun main() {

  /**
   * Lambdas
   */

  val timesTwo: (Int) -> Int = { x: Int -> x * 2 }
  println("$timesTwo: " + timesTwo(8))

  val timesTwo1 = { x: Int -> x * 2 }
  println("$timesTwo1: " + timesTwo1(-76))

  val addTwoNumbers: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
  println("$addTwoNumbers: " + addTwoNumbers(5, 6))

  val addTwoNumbers1 = { x: Int, y: Int -> x + y }
  println("$addTwoNumbers1: " + addTwoNumbers1(-10, 20.8.roundToInt()))

  val list = (1..100).toList()

  /**
   * Filter
   */

  val filteredList1 = list.filter { item -> item % 2 == 0 }
  println(filteredList1)

  val filteredList2 = list.filter { it % 2 == 0 }
  println(filteredList2)

  val filteredList3 = list.filter(::isEven)
  println(filteredList3)

  val filteredList4 = list.filter { it.even() }
  println(filteredList4)

}

fun isEven(i: Int) = i % 2 == 0

fun Int.even() = this % 2 == 0