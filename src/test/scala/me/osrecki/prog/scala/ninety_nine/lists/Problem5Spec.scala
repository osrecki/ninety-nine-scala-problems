package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem5._

class Problem5Spec extends FlatSpec with Matchers {
  it should "return Nil for an empty list" in {
    reverseBuiltIn(Nil) shouldBe empty
    reverseFold(Nil) shouldBe empty
    reverseRecursive(Nil) shouldBe empty
  }

  it should "reverse a list with a single element" in {
    val singleton = List(1)

    reverseBuiltIn(singleton) shouldBe singleton
    reverseFold(singleton) shouldBe singleton
    reverseRecursive(singleton) shouldBe singleton
  }

  it should "reverse a list with many elements" in {
    val list = List(10, 44, -1, 0, -23, 100)
    val reversed = List(100, -23, 0, -1, 44, 10)

    reverseBuiltIn(list) shouldBe reversed
    reverseFold(list) shouldBe reversed
    reverseRecursive(list) shouldBe reversed
  }
}
