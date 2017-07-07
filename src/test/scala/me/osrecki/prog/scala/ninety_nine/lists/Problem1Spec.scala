package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem1._

class Problem1Spec extends FlatSpec with Matchers {
  it should "return a last element of a list with a single element" in {
    val list = Seq(1)

    lastBuiltIn(list) shouldBe 1
    lastRecursive(list) shouldBe 1
  }

  it should "return a last element of a list with multiple elements" in {
    val list = Seq(1, 1, 2, 3, 5, 8)

    lastBuiltIn(list) shouldBe 8
    lastRecursive(list) shouldBe 8
  }

  it should "throw a NoSuchElementException for an empty list" in {
    val list = Nil

    a[NoSuchElementException] should be thrownBy lastBuiltIn(list)
    a[NoSuchElementException] should be thrownBy lastRecursive(list)
  }
}
