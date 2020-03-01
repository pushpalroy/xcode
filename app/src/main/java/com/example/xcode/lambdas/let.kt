package com.example.xcode.lambdas

import android.util.Log
import java.io.File
import java.util.Locale

fun main() {

  /**
   * Scoping
   */

  try {
    File("readme.txt").bufferedReader()
        .let {
          if (it.ready()) {
            println(it.readLine())
          }
        }
  } catch (e: Exception) {
  }

  val s: String? = "This can be null"

  /**
   * Working with nullable
   */
  s?.let {
    if (s.isNotEmpty()) {
      print(s.toLowerCase(Locale.getDefault()))
    }
  }
}