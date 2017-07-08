package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem9._

class Problem9Spec extends FlatSpec with Matchers {
  it should "pack consecutive duplicates of list elements into sub-lists" in {
    val list1 = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    val packed1 = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

    packFold(list1) shouldBe packed1
    packRecursive(list1) shouldBe packed1

    val list2 = List('a, 'b', 'c)
    val packed2 = list2.map(List(_))
    packFold(list2) shouldBe packed2
    packRecursive(list2) shouldBe packed2
  }
}
