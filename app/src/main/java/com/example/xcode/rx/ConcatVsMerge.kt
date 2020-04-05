package com.example.xcode.rx

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
  val listFirst = arrayOf("A1", "A2", "A3", "A4")
  val listSecond = arrayOf("B1", "B2", "B3")

  val observableFirst = Observable.fromArray(listFirst)
  val observableSecond = Observable.fromArray(listSecond)

  //concat(observableFirst = observableFirst, observableSecond = observableSecond)
  merge(observableFirst = observableFirst, observableSecond = observableSecond)
}

/**
 * Concat emits the emissions from two or more Observables without interleaving them.
 * It will maintain the order of the observables while emitting the items.
 * It means that it will emit all the items of the first observable and
 * then it will emit all the items of the second observable and so on.
 */
private fun concat(
  observableFirst: Observable<Array<String>>,
  observableSecond: Observable<Array<String>>
) {
  Observable.concat(observableFirst, observableSecond)
      .subscribe(object : Observer<Array<String>> {
        override fun onSubscribe(d: Disposable) {
          println("onSubscribe called")
        }

        override fun onNext(t: Array<String>) {
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

/**
 * Merge combines multiple Observables into one by merging their emissions.
 * It will not maintain the order while emitting the items.
 */
private fun merge(
  observableFirst: Observable<Array<String>>,
  observableSecond: Observable<Array<String>>
) {
  Observable.merge(observableFirst, observableSecond)
      .subscribe(object : Observer<Array<String>> {
        override fun onSubscribe(d: Disposable) {
          println("onSubscribe called")
        }

        override fun onNext(t: Array<String>) {
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
