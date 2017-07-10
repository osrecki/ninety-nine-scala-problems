package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem20._

class Problem20Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd)

  it should "remove the first element from a list" in {
    removeAt(0, list) shouldBe (List('b, 'c, 'd), 'a)
  }

  it should "remove the last element from a list" in {
    removeAt(3, list) shouldBe (List('a, 'b, 'c), 'd)
  }

  it should "remove inner element from a list" in {
    removeAt(1, list) shouldBe (List('a, 'c, 'd), 'b)
  }

  it should "throw a NoSuchElementException if index is less than zero" in {
    a[NoSuchElementException] should be thrownBy removeAt(-1, list)
  }

  it should "throw a NoSuchElementException if index is greater than or equal to the list size" in {
    a[NoSuchElementException] should be thrownBy removeAt(4, list)
  }
}
