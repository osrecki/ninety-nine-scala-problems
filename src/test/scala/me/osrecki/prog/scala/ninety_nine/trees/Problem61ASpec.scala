package me.osrecki.prog.scala.ninety_nine.trees

import org.scalatest.{ FlatSpec, Matchers }

class Problem61ASpec extends FlatSpec with Matchers {
  it should "collect the leaves of a tree in a list" in {
    val tree = Node('a', Node('b'), Node('c', Node('d'), Node('e')))

    tree.leafList shouldBe List('b', 'd', 'e')
  }

  it should "return the empty list for the End node" in {
    End.leafList shouldBe Nil
  }
}
