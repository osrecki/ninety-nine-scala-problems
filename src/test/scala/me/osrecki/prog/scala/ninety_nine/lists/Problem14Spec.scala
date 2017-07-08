package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem14._

class Problem14Spec extends FlatSpec with Matchers {
  it should "duplicate the elements of a list" in {
    val list = List('a, 'b, 'c, 'c, 'd)
    val duplicated = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

    duplicateBuiltIn(list) shouldBe duplicated
    duplicateFold(list) shouldBe duplicated
    duplicateRecursive(list) shouldBe duplicated
    duplicateBuffer(list) shouldBe duplicated
  }

  it should "return Nil for an empty list" in {
    duplicateBuiltIn(Nil) shouldBe Nil
    duplicateFold(Nil) shouldBe Nil
    duplicateRecursive(Nil) shouldBe Nil
    duplicateBuffer(Nil) shouldBe Nil
  }
}
