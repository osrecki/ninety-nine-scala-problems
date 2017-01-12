package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem8._

class Problem8Spec extends FlatSpec with Matchers {
  it should "eliminate consecutive duplicates in a list" in {
    val list        = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val compressed  = List('a, 'b, 'c, 'a, 'd, 'e)

    compressFold(list)      shouldBe compressed
    compressRecursive(list) shouldBe compressed

    compressFold(compressed)      shouldBe compressed
    compressRecursive(compressed) shouldBe compressed
  }
}
