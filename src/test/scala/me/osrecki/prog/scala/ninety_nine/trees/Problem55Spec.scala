package me.osrecki.prog.scala.ninety_nine.trees

import org.scalatest.{FlatSpec, Matchers}

class Problem55Spec extends FlatSpec with Matchers {
  private val element = 'x'

  it should "construct completely balanced binary tree with 4 nodes" in {
    val trees = Tree.cBalanced(4, element)

    val tree1 = Node(element, Node(element, Node(element), End), Node(element))
    val tree2 = Node(element, Node(element, End, Node(element)), Node(element))
    val tree3 = Node(element, Node(element), Node(element, Node(element), End))
    val tree4 = Node(element, Node(element), Node(element, End, Node(element)))

    trees should contain theSameElementsAs List(tree1, tree2, tree3, tree4)
  }

  it should "construct completely balanced binary tree with 3 nodes" in {
    val trees = Tree.cBalanced(3, element)

    trees should contain theSameElementsAs List(Node(element, Node(element), Node(element)))
  }

  it should "construct completely balanced binary tree with 2 nodes" in {
    val trees = Tree.cBalanced(2, element)

    trees should contain theSameElementsAs List(Node('x', Node('x'), End), Node('x', End, Node('x')))
  }

  it should "construct completely balanced binary tree with 1 node" in {
    val trees = Tree.cBalanced(1, element)

    trees shouldBe List(Node('x'))
  }
}
