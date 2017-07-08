package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem17._

class Problem17Spec extends FlatSpec with Matchers {
  val list = 1 to 10

  it should "split a list before the first element" in {
    val split = (Nil, list)

    splitBuiltIn(0, list) shouldBe split
    splitFunctional(0, list) shouldBe split
    splitRecursive(0, list) shouldBe split
  }

  it should "split a list in two parts" in {
    val split = (1 to 3, 4 to 10)

    splitBuiltIn(3, list) shouldBe split
    splitFunctional(3, list) shouldBe split
    splitRecursive(3, list) shouldBe split
  }

  it should "split a list after the last element" in {
    val split = (1 to 10, Nil)

    splitBuiltIn(10, list) shouldBe split
    splitFunctional(10, list) shouldBe split
    splitRecursive(10, list) shouldBe split
  }

  it should "return (Nil, Nil) for an empty list" in {
    val split = (Nil, Nil)

    splitBuiltIn(10, Nil) shouldBe split
    splitFunctional(10, Nil) shouldBe split
    splitRecursive(10, Nil) shouldBe split
  }
}
