package com.example.xcode.rx

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

/**
 * Here we can see that the brandObservable is getting the "DEFAULT" as the brand of the car and
 * the brandDeferObservable is getting "BMW" as the brand of the car.
 *
 * brandObservable is returning the old value which is "DEFAULT" as it has not used the defer operator.
 * brandDeferObservable is returning the latest value which is "BMW" as it has used the defer operator.
 *
 * Two important things to keep in mind:
 * - Defer do not create the Observable until the observer subscribes.
 * - Defer create a fresh observable for each observer.
 */
fun main() {
  val compositeDisposable = CompositeDisposable()
  val car = Car()

  val brandObservable = car.getBrandObservable()
  val brandDeferObservable = car.getBrandDeferObservable()

  car.brand = "BMW"

  compositeDisposable.add(
      brandObservable.subscribe {
        println("brandObservable: $it")
      })

  compositeDisposable.add(
      brandDeferObservable.subscribe {
        println("brandDeferObservable: $it")
      })
}

class Car {
  var brand: String = "DEFAULT"

  fun getBrandObservable(): Observable<String> {
    return Observable.just(brand)
  }

  fun getBrandDeferObservable(): Observable<String> {
    return Observable.defer {
      return@defer Observable.just(brand)
    }
  }
}