package me.osrecki.prog.scala.ninety_nine.logic

import org.scalatest.{FlatSpec, Matchers}
import S99Boolean._

class Problem49Spec extends FlatSpec with Matchers {
  it should "construct an n-bit Gray code" in {
    all(grayFunctions(1)) shouldBe Seq("0", "1")
    all(grayFunctions(2)) shouldBe Seq("00", "01", "11", "10")
    all(grayFunctions(3)) shouldBe Seq("000", "001", "011", "010", "110", "111", "101", "100")
  }

  private def grayFunctions(n: Int): Seq[Seq[String]] = {
    Seq(gray(n), grayMemoization(n))
  }
}
