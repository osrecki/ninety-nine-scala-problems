package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{ FlatSpec, Matchers }
import S99Int._

class Problem39Spec extends FlatSpec with Matchers {
  it should "create a list of integers in specified range" in {
    listPrimesInRange(7 to 31) shouldBe Seq(7, 11, 13, 17, 19, 23, 29, 31)
  }
}
