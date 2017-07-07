package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem20._

class Problem20Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd)

  it should "remove Kth element from a list" in {
    removeAt(0, list) shouldBe (List('b, 'c, 'd), 'a)
    removeAt(1, list) shouldBe (List('a, 'c, 'd), 'b)
    removeAt(3, list) shouldBe (List('a, 'b, 'c), 'd)
  }

  it should "throw a NoSuchElementException for K out of bounds" in {
    a[NoSuchElementException] should be thrownBy removeAt(-1, list)
    a[NoSuchElementException] should be thrownBy removeAt(4, list)
  }
}
