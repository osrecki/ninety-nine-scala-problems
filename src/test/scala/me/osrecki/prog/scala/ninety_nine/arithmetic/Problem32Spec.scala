package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{ FlatSpec, Matchers }
import S99Int.gcd

class Problem32Spec extends FlatSpec with Matchers {
  it should "calculate the greatest common divisor of two numbers" in {
    gcd(36, 63) shouldBe 9
    gcd(63, 36) shouldBe 9

    gcd(10, 0) shouldBe 10
    gcd(0, 10) shouldBe 10

    gcd(10, 1) shouldBe 1
    gcd(1, 10) shouldBe 1
  }
}
