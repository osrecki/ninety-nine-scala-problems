package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem16._

class Problem16Spec extends FlatSpec with Matchers {
  val list      = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  it should "drop each element from a list" in {
    dropBuiltIn(1, list)    shouldBe Seq.empty
    dropRecursive(1, list)  shouldBe Seq.empty
  }

  it should "drop every 3rd element from a list" in {
    val filtered  = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

    dropBuiltIn(3, list)    shouldBe filtered
    dropRecursive(3, list)  shouldBe filtered
  }
}
