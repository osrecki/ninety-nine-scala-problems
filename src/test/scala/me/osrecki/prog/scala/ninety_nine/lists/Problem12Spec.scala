package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem12._

class Problem12Spec extends FlatSpec with Matchers {
  it should "decode a run-length encoded list" in {
    val list = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    val decoded = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

    decode(list) shouldBe decoded
  }
}
