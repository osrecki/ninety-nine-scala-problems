package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem25._

class Problem25Spec extends FlatSpec with Matchers {
  it should "generate a random permutation of the elements of a list" in {
    val list = List('a, 'b, 'c, 'd, 'e, 'f)

    randomPermute(list, seed = 1) shouldBe List('f, 'c, 'a, 'b, 'e, 'd)
    randomPermuteArray(list, seed = 1) shouldBe List('e, 'c, 'a, 'b, 'f, 'd)
  }
}
