package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem9._

class Problem9Spec extends FlatSpec with Matchers {
  it should "pack consecutive duplicates of list elements into sub-lists" in {
    val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val packed = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

    packFold(list) shouldBe packed
    packRecursive(list) shouldBe packed
  }

  it should "pack a list without duplicates" in {
    val list = List('a, 'b', 'c)
    val packed = list.map(List(_))

    packFold(list) shouldBe packed
    packRecursive(list) shouldBe packed
  }

  it should "return Nil for an empty list" in {
    packFold(Nil) shouldBe Nil
    packRecursive(Nil) shouldBe Nil
  }
}
