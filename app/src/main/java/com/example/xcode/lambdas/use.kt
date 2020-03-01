package com.example.xcode.lambdas

import java.io.FileReader

fun main() {

  /**
   * This will automatically call close(). Used for I/O Operations.
   */

  FileReader("someFile.txt").use {
    val str = it.readText()
    println(str)
  }
}