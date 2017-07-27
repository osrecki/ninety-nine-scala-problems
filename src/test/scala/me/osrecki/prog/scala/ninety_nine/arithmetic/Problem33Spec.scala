package me.osrecki.prog.scala.ninety_nine.arithmetic

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.Inspectors._
import S99Int.intToS99Int

class Problem33Spec extends FlatSpec with Matchers {
  it should "return true for two comprime integers" in {
    val coprimes = Seq((1, 10), (3, 5), (13, 17), (2, 3), (8, 9), (25, 36), (35, 64), (48, 65))

    testIsComprimeTo(coprimes, expected = true)
  }

  it should "return false if two integers are not coprime" in {
    val notCoprimes = Seq((2, 4), (3, 9), (10, 100), (20, 520), (1000, 100000))

    testIsComprimeTo(notCoprimes, expected = false)
  }

  private def testIsComprimeTo(seq: Seq[(Int, Int)], expected: Boolean): Unit = {
    forAll(seq) { t =>
      t._1.isComprimeTo(t._2) shouldBe expected
      t._2.isComprimeTo(t._1) shouldBe expected
    }
  }
}
