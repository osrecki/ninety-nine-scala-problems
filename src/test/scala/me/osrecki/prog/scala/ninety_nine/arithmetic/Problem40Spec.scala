package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{ FlatSpec, Matchers }
import S99Int._

class Problem40Spec extends FlatSpec with Matchers {
  it should "find two prime numbers that sum up to a given number" in {
    28.goldbach shouldBe (5, 23)
  }
}
