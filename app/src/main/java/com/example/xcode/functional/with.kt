package com.example.xcode.functional

fun main() {

  val props = System.getProperties()

  /**
   * Calling multiple functions on the same object
   */

  with(props) {
    list(System.out)
    println(propertyNames().toList())
    println(getProperty("user.home"))
  }
}