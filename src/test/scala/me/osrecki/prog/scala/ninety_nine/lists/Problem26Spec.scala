package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem26._

class Problem26Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd, 'e, 'f)

  it should "generate empty list if k greater than list size" in {
    combinations(7, list) shouldBe empty
  }

  it should "generate combinations of one element" in {
    combinations(1, list) shouldBe list.map(List(_))
  }

  it should "generate the combinations of k distinct elements" in {
    combinations(3, list) should have size 20
  }
}
