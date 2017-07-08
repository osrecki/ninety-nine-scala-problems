package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem13._

class Problem13Spec extends FlatSpec with Matchers {
  it should "return an empty List[(Int, A)) for an empty List[A]" in {
    encodeDirect(Seq.empty[Symbol]) shouldBe Seq.empty[(Int, Symbol)]
  }

  it should "run-length encode a list" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val encoded = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))

    encodeDirect(list) shouldBe encoded
  }
}
