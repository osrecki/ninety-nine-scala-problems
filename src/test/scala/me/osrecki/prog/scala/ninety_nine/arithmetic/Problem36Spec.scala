package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{FlatSpec, Matchers}
import S99Int.intToS99Int

class Problem36Spec extends FlatSpec with Matchers {
  it should "construct a map with prime factors and their multiplicity" in {
    3.primeFactorsMultiplicity shouldBe Map(3 -> 1)
    10.primeFactorsMultiplicity shouldBe Map(2 -> 1, 5 -> 1)
    99.primeFactorsMultiplicity shouldBe Map(3 -> 2, 11 -> 1)
    315.primeFactorsMultiplicity shouldBe Map(3 -> 2, 5 -> 1, 7 -> 1)
  }
}
