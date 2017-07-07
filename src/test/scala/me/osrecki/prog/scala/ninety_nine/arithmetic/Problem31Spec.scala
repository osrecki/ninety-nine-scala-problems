package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{ FlatSpec, Matchers }
import org.scalatest.Inspectors._
import S99Int.intToS99Int

class Problem31Spec extends FlatSpec with Matchers {
  it should "return true for prime numbers" in {
    val numbers = Seq(2, 3, 5, 7, 11, 13, 17)

    forAll(numbers) { _.isPrime shouldBe true }
  }

  it should "return false for numbers that are not prime" in {
    val numbers = Seq(-10, 0, 1, 4, 6, 8, 9, 10, 20, 100)

    forAll(numbers) { _.isPrime shouldBe false }
  }
}
