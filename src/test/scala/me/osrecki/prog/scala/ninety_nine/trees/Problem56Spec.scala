package me.osrecki.prog.scala.ninety_nine.trees

import org.scalatest.{ FlatSpec, Matchers }

class Problem56Spec extends FlatSpec with Matchers {
  it should "return true for the symmetric tree" in {
    val tree = Node('a', Node('b'), Node('c'))

    tree.isSymmetric shouldBe true
  }

  it should "return false for the asymmetric tree" in {
    val tree = Node('a', Node('b', Node('c'), End), Node('d'))

    tree.isSymmetric shouldBe false
  }
}
