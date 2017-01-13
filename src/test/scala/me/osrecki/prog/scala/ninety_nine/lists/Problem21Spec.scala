package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem21._

class Problem21Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd)
  val elem = 'x

  it should "insert an element at the head of the list" in {
    val newList = elem +: list

    insertAt(elem, -10, list) shouldBe newList
    insertAt(elem, 0, list)   shouldBe newList
  }

  it should "insert an element in the middle of the list" in {
    insertAt(elem, 2, list) shouldBe List('a, 'b, 'x, 'c, 'd)
  }

  it should "insert an element at the end of the list" in {
    val newList = List('a, 'b, 'c, 'd, 'x)

    insertAt(elem, 4, list) shouldBe newList
    insertAt(elem, 100, list) shouldBe newList
  }
}
