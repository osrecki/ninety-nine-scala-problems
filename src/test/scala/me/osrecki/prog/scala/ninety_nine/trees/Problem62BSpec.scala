package me.osrecki.prog.scala.ninety_nine.trees

import org.scalatest.{FlatSpec, Matchers}

class Problem62BSpec extends FlatSpec with Matchers {
  private val tree = Node('a', Node('b'), Node('c', Node('d'), Node('e')))

  it should "collect the nodes at a given level in a tree" in {
    tree.atLevel(2) shouldBe List('b', 'c')
  }

  it should "throw an exception if the level is not greater than zero" in {
    val exception = the[IllegalArgumentException] thrownBy tree.atLevel(0)
    exception.getMessage should equal("requirement failed: Root is at the level 1.")
  }

  it should "return an empty list for the End node" in {
    End.atLevel(2) shouldBe Nil
  }
}
