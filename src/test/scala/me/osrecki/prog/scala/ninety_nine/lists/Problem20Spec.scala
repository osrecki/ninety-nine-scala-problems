package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem20._

class Problem20Spec extends FlatSpec with Matchers {
  it should "remove Kth element from a list" in {
    val list = List('a, 'b, 'c, 'd)

    removeAt(1, list) shouldBe (List('a, 'c, 'd),'b)
  }
}
