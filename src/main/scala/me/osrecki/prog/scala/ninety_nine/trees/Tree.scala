package me.osrecki.prog.scala.ninety_nine.trees

sealed abstract class Tree[+T] {
  /**
    * Let us call a binary tree symmetric if you can draw a vertical line
    * through the root node and then the right subtree is the mirror image
    * of the left subtree. Add an isSymmetric method to the Tree class to
    * check whether a given binary tree is symmetric.
    *
    * ==Example==
    * {{{
    * scala> Node('a', Node('b'), Node('c')).isSymmetric
    * res0: Boolean = true
    * }}}
    */
  def isSymmetric: Boolean

  /**
    * Write an isMirrorOf method first to check whether one tree is the mirror
    * image of another. We are only interested in the structure, not in the
    * contents of the nodes.
    */
  def isMirrorOf[U](tree: Tree[U]): Boolean

  /**
    * A leaf is a node with no successors. Write a method leafCount to count them.
    */
  def leafCount: Int
}

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def isSymmetric: Boolean = left.isMirrorOf(right) && right.isMirrorOf(left)

  override def isMirrorOf[U](tree: Tree[U]): Boolean = tree match {
    case node: Node[U]  => left.isMirrorOf(node.right) && right.isMirrorOf(node.left)
    case _              => false
  }

  override def leafCount: Int = (left, right) match {
    case (End, End) => 1
    case _          => left.leafCount + right.leafCount
  }

  override def toString: String = s"T(${value.toString} ${left.toString} ${right.toString})"
}

case object End extends Tree[Nothing] {
  override def isSymmetric: Boolean = true

  override def isMirrorOf[U](tree: Tree[U]): Boolean = tree == End

  override def leafCount: Int = 0

  override def toString: String = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
