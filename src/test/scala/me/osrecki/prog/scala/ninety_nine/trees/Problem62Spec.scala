package me.osrecki.prog.scala.ninety_nine.trees

import org.scalatest.{FlatSpec, Matchers}

class Problem62Spec extends FlatSpec with Matchers {
  it should "collect all internal nodes of a tree" in {
    val tree = Node('a', Node('b'), Node('c', Node('d'), Node('e')))
    tree.internalList shouldBe List('a', 'c')
  }

  it should "return an empty list for a leaf node" in {
    val leaf = Node('x')

    leaf.internalList shouldBe Nil
  }

  it should "return an empty list for the End node" in {
    End.internalList shouldBe Nil
  }
}
