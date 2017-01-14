package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem23._

class Problem23Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'd, 'f, 'g, 'h)
  val seed = 1

  it should "extract 0 elements from a list" in {
    randomSelect(-1, list, seed)  shouldBe Nil
    randomSelect(0, list, seed)   shouldBe Nil
  }

  it should "extract 1 randomly selected element from a list" in {
    randomSelect(1, list, seed) shouldBe List('f)
  }

  it should "extract 2 randomly selected elements from a list" in {
    randomSelect(2, list, seed) shouldBe List('g, 'f)
  }

  it should "extract all elements from a list" in {
    randomSelect(100, list, seed) shouldBe List('d, 'a, 'h, 'b, 'c, 'g, 'f)
  }
}
