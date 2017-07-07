package me.osrecki.prog.scala.ninety_nine.trees

import org.scalatest.{ FlatSpec, Matchers }

class Problem61Spec extends FlatSpec with Matchers {
  it should "count the number of leaves in a tree" in {
    val tree = Node('x', Node('x'), End)
    tree.leafCount shouldBe 1

    val tree2 = Node('x', Node('x', Node('x'), End), Node('x', End, Node('x')))
    tree2.leafCount shouldBe 2
  }

  it should "return zero for the End node" in {
    End.leafCount shouldBe 0
  }
}
