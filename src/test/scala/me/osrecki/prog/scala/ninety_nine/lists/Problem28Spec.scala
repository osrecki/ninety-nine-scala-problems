package me.osrecki.prog.scala.ninety_nine.lists

import org.scalatest.{FlatSpec, Matchers}
import Problem28._

class Problem28Spec extends FlatSpec with Matchers {
  val lists = List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e),
    List('i, 'j, 'k, 'l), List('m, 'n), List('o))

  it should "sort a list of lists according to the length of sublists" in {
    val sorted = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n),
      List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))

    lsort(lists) shouldBe sorted
  }

  it should "sort a list of lists according to the length frequency of sublists" in {
    val sorted = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c),
      List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

    lsortFreq(lists) shouldBe sorted
  }
}
