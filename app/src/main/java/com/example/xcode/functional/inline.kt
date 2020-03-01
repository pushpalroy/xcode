@file:Suppress("NOTHING_TO_INLINE")

package com.example.xcode.functional

import java.util.Locale

inline fun modifyString(
  str: String,
  noinline operation: (String) -> String
): String {
  return operation(str)
}

fun main() {
  val modifiedStr = modifyString("Higher order functions are amazing!") {
    it.toUpperCase(Locale.ROOT)
  }

  println(modifiedStr)
}