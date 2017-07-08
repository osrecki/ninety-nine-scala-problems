package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem15._

class Problem15Spec extends FlatSpec with Matchers {
  val list = List('a, 'b, 'c, 'c, 'd)

  it should "duplicate the elements of a list zero times" in {
    duplicateN(0, list) shouldBe Seq.empty
    duplicateNFold(0, list) shouldBe Seq.empty
    duplicateNRecursive(0, list) shouldBe Seq.empty
    duplicateNBuffer(0, list) shouldBe Seq.empty
  }

  it should "copy the elements of a list once" in {
    duplicateN(1, list) shouldBe list
    duplicateNFold(1, list) shouldBe list
    duplicateNRecursive(1, list) shouldBe list
    duplicateNBuffer(1, list) shouldBe list
  }

  it should "double the elements of a list" in {
    val doubled = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

    duplicateN(2, list) shouldBe doubled
    duplicateNFold(2, list) shouldBe doubled
    duplicateNRecursive(2, list) shouldBe doubled
    duplicateNBuffer(2, list) shouldBe doubled
  }
}
