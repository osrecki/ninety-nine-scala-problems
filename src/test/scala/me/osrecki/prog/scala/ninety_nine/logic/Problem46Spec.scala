package me.osrecki.prog.scala.ninety_nine
package logic

import org.scalatest.{FlatSpec, Matchers}
import S99Logic._
import TestUtility._

class Problem46Spec extends FlatSpec with Matchers {
  it should "print the truth table for AND function" in {
    val andExpected =
      s"""P     Q     Result
        |true  true  true${" "}
        |true  false false
        |false true  false
        |false false false
        |""".stripMargin

    printlnToString(table2(and)) shouldBe andExpected
  }

  it should "print the truth table for OR function" in {
    val orExpected =
      s"""P     Q     Result
        |true  true  true${" "}
        |true  false true${" "}
        |false true  true${" "}
        |false false false
        |""".stripMargin

    printlnToString(table2(or)) shouldBe orExpected
  }

  it should "print the truth table for the IMPL function" in {
    val implExpected =
      s"""P     Q     Result
        |true  true  true${" "}
        |true  false false
        |false true  true${" "}
        |false false true${" "}
        |""".stripMargin

    printlnToString(table2(impl)) shouldBe implExpected
  }
}
