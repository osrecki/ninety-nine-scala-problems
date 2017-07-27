package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{FlatSpec, Matchers}
import S99Int.intToS99Int

class Problem35Spec extends FlatSpec with Matchers {
  it should "return the prime factors of a given number" in {
    0.primeFactors shouldBe Seq.empty[Int]
    1.primeFactors shouldBe Seq.empty[Int]
    2.primeFactors shouldBe Seq(2)
    11.primeFactors shouldBe Seq(11)
    12.primeFactors shouldBe Seq(2, 2, 3)
    147.primeFactors shouldBe Seq(3, 7, 7)
    315.primeFactors shouldBe Seq(3, 3, 5, 7)
  }
}
