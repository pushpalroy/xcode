package com.example.xcode.lambdas

/**
 * Implementation of Sieve of Eratosthenes using lazy sequences
 * to generate a sequence of prime numbers by filtering out multiples
 */
fun main() {

  val possiblePrimesAfterTwo = generateSequence(3) { it + 2 }

  val primes = generateSequence(2 to possiblePrimesAfterTwo) {

    // Next prime number
    val p = it.second.first()

    // Filter out all elements divisible by p
    val possiblePrimesAfterP = it.second.filter { it % p != 0 }

    // Return the next element in the sequence
    p to possiblePrimesAfterP

  }.map { it.first }

  print("First 20 primes: ${primes.take(20).toList()}")
}