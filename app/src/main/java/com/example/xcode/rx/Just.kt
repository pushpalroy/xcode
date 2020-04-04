package com.example.xcode.rx

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
  Observable.just(1, 2, 3, 4)
      .subscribe(object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
          println("onSubscribe called")
        }

        override fun onNext(t: Int) {
          if (t == 3) {
            throw NullPointerException("Its a NPE")
          }
          println("onNext called: $t")
        }

        override fun onError(e: Throwable) {
          println("onError called: ${e.message}")
        }

        override fun onComplete() {
          println("onComplete called")
        }
      })
}
