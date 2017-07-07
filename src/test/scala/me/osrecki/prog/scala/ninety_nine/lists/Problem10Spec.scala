package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{ FlatSpec, Matchers }
import Problem10._

class Problem10Spec extends FlatSpec with Matchers {
  it should "run-length encode a list" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val encoded = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    encode(list) shouldBe encoded
  }
}
