package com.example.xcode.functional

import java.io.FileReader

fun main() {

  /**
   * This will automatically call close(). Used for I/O Operations.
   * Substitute of try-with-resources of Java
   */

  FileReader("someFile.txt").use {
    val str = it.readText()
    println(str)
  }
}