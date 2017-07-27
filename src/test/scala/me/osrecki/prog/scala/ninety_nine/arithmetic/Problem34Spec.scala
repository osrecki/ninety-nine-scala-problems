package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{FlatSpec, Matchers}
import S99Int.intToS99Int

class Problem34Spec extends FlatSpec with Matchers {
  it should "calculate totient function for a given number" in {
    val numbers = 1 to 15
    val expected = Seq(1, 1, 2, 2, 4, 2, 6, 4, 6, 4, 10, 4, 12, 6, 8)

    numbers.map(_.totient) shouldBe expected
  }
}
