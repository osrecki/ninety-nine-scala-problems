package me.osrecki.prog.scala.ninety_nine.lists

import me.osrecki.prog.scala.ninety_nine.lists.Problem11.encodeModified
import org.scalatest.{FlatSpec, Matchers}

class Problem11Spec extends FlatSpec with Matchers {
  it should "run-length encode a list" in {
    val list    = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val encoded = List(Right(4,'a), Left('b), Right(2,'c), Right(2,'a), Left('d), Right(4,'e))

    encodeModified(list) shouldBe encoded
  }
}
