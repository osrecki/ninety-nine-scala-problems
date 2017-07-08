package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem7._

class Problem7Spec extends FlatSpec with Matchers {
  it should "flatten a list with deeply nested lists" in {
    val list1 = List(List(1, 1), 2, List(3, List(5, 8)))
    flatten(list1) shouldBe List(1, 1, 2, 3, 5, 8)

    val list2 = List("This", List("is", List("a", "very", List("nested", List("list", ".")))))
    flatten(list2) shouldBe "This is a very nested list .".split(" ").toSeq
  }
}
