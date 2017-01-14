package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem24._

class Problem24Spec extends FlatSpec with Matchers {
  it should "draw n different numbers from a range 1..m" in {
    lotto(6, 49, seed = 1) shouldBe List(25, 49, 38, 28, 29, 47)
  }
}
