package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem4._

class Problem4Spec extends FlatSpec with Matchers {
  it should "return zero for an empty list" in {
    lengthBuiltIn(Nil) shouldBe 0
    lengthFold(Nil) shouldBe 0
    lengthRecursive(Nil) shouldBe 0
  }

  it should "return the length of a non-empty list" in {
    val list = List(10, 44, -1, 0, -23, 100)

    lengthBuiltIn(list) shouldBe 6
    lengthFold(list) shouldBe 6
    lengthRecursive(list) shouldBe 6
  }
}
