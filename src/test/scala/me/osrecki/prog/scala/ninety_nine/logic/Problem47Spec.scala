package me.osrecki.prog.scala.ninety_nine.logic

import me.osrecki.prog.scala.ninety_nine.TestUtility.printlnToString
import me.osrecki.prog.scala.ninety_nine.logic.S99Boolean.{booleanToS99Boolean, not => ¬}
import me.osrecki.prog.scala.ninety_nine.logic.S99Logic.table2
import org.scalatest.{FlatSpec, Matchers}

class Problem47Spec extends FlatSpec with Matchers {
  it should "print the truth table for NAND function" in {
    val nandExpected =
      s"""P     Q     Result
        |true  true  false
        |true  false true${" "}
        |false true  true${" "}
        |false false true${" "}
        |""".stripMargin

    printlnToString(table2((p: Boolean, q: Boolean) => ¬(p and q))) shouldBe nandExpected
  }
}
