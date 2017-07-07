package me.osrecki.prog.scala.ninety_nine
package arithmetic

import org.scalatest.{ FlatSpec, Matchers }
import TestUtility._

import S99Int._

class Problem41Spec extends FlatSpec with Matchers {
  it should "print list of Goldbach compositions for a given range" in {
    val expected =
      """10 = 3 + 7
        |12 = 5 + 7
        |14 = 3 + 11
        |16 = 3 + 13
        |18 = 5 + 13
        |20 = 3 + 17
        |""".stripMargin

    printlnToString { printGoldbachList(9 to 20) } shouldBe expected
  }

  it should "print limited list of Goldbach composition for a given range" in {
    val expected =
      """992 = 73 + 919
        |1382 = 61 + 1321
        |1856 = 67 + 1789
        |1928 = 61 + 1867
        |""".stripMargin

    printlnToString { printGoldbachListLimited(1 to 2000, 50) } shouldBe expected
  }
}
