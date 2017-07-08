package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem22._

class Problem22Spec extends FlatSpec with Matchers {
  it should "create a list with a single element" in {
    val range = List(2)

    rangeBuiltIn(2, 2) shouldBe range
    rangeRecursive(2, 2) shouldBe range
  }

  it should "create a list between 4 and 9" in {
    val range = List.range(4, 10)

    rangeBuiltIn(4, 9) shouldBe range
    rangeRecursive(4, 9) shouldBe range
  }
}
