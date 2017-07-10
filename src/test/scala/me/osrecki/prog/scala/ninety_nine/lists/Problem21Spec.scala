package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem21._

class Problem21Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd)
  val elem = 'x

  it should "insert an element at the head of a list when index is less than zero" in {
    insertAt(elem, -10, list) shouldBe List('x, 'a, 'b, 'c, 'd)
  }

  it should "insert an element at the head of a list when index is equal to zero" in {
    insertAt(elem, 0, list) shouldBe List('x, 'a, 'b, 'c, 'd)
  }

  it should "insert an element in the middle of a list" in {
    insertAt(elem, 2, list) shouldBe List('a, 'b, 'x, 'c, 'd)
  }

  it should "insert an element at the end of a list when index is equal to the size of the list" in {
    insertAt(elem, 4, list) shouldBe List('a, 'b, 'c, 'd, 'x)
  }

  it should "insert an element at the end of a list when index is greater than the size of the list" in {
    insertAt(elem, 100, list) shouldBe List('a, 'b, 'c, 'd, 'x)
  }
}
