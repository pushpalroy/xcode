package com.example.xcode.rx

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction

fun main() {
  zip()
}

/**
 * Zip combine the emissions of multiple Observables together via a specified function
 * and emit single items for each combination based on the results of this function
 *
 * We have two different observables which will return the two dummy array-list as API response.
 * In the observableOne, we get an Exception because the size is one and as it gets an error it will return an empty list.
 * In observableTwo, we would get apiResponseTwo array-list as return value as Observable.
 *
 * The purpose to explain this example is that even if any API call fails in a Rx operation,
 * we would still be able to complete task without halting the operation or stopping the app.
 */
private fun zip() {
  val apiResponseOne = ArrayList<String>()
  val apiResponseTwo = ArrayList<String>()

  apiResponseOne.add("Response of API-1")
  apiResponseTwo.add("Response of API-2")

  val observableOne = Observable.just(apiResponseOne)
      .map {
        if (it.size == 1) {
          println("NullPointerException")
          throw NullPointerException("Its a NPE")
        }
        it
      }
      .onErrorReturn { ArrayList() }

  val observableTwo = Observable.just(apiResponseTwo)
      .map { it }
      .onErrorReturn { ArrayList() }

  Observable.zip(
      observableOne,
      observableTwo,
      BiFunction<ArrayList<String>, ArrayList<String>, ArrayList<String>> { output1, output2 ->
        println("Size of output: " + outputFunction(output1, output2).size.toString())
        return@BiFunction outputFunction(output1, output2)
      })
      .subscribe(object : Observer<ArrayList<String>> {
        override fun onSubscribe(d: Disposable) {
          println("onSubscribe called")
        }

        override fun onNext(t: ArrayList<String>) {
          t.forEach {
            println("onNext called: $it")
          }
        }

        override fun onError(e: Throwable) {
          println("onError called: ${e.message}")
        }

        override fun onComplete() {
          println("onComplete called")
        }
      })
}

private fun outputFunction(
  outputOne: ArrayList<String>,
  outputTwo: ArrayList<String>
): ArrayList<String> {
  val output = ArrayList<String>()
  output.addAll(outputOne)
  output.addAll(outputTwo)
  return output
}