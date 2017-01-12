package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem2._

class Problem2Spec extends FlatSpec with Matchers {
  it should "return the last but one element of a list with two elements" in {
    val list = List(-10, 25)

    penultimateBuiltIn(list)   shouldBe -10
    penultimateRecursive(list) shouldBe -10
  }

  it should "return the last but one element of a list with more than two elements" in {
    val list = List(4, 10, 8, -10, 20, 33)

    penultimateBuiltIn(list)   shouldBe 20
    penultimateRecursive(list) shouldBe 20
  }

  it should "throw a NoSuchElementException for lists with less than two elements" in {
    val singleton = List(1)

    a [NoSuchElementException] should be thrownBy penultimateBuiltIn(singleton)
    a [NoSuchElementException] should be thrownBy penultimateBuiltIn(Nil)

    a [NoSuchElementException] should be thrownBy penultimateRecursive(singleton)
    a [NoSuchElementException] should be thrownBy penultimateRecursive(Nil)
  }
}
