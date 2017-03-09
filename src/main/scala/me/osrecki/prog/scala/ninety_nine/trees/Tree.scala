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
    *
    * ==Example==
    * {{{
    * scala> Node('x', Node('x'), End).leafCount
    * res0: Int = 1
    * }}}
    */
  def leafCount: Int

  /**
    * A leaf is a node with no successors. Write a method leafList to collect
    * them in a list.
    *
    * ==Example==
    * {{{
    * scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
    * res0: List[Char] = List(b, d, e)
    * }}}
    */
  def leafList: List[T]

  /**
    * Collect the internal nodes of a binary tree in a list.
    * An internal node of a binary tree has either one or two non-empty successors.
    * Write a method internalList to collect them in a list.
    *
    * ==Example==
    * {{{
    * scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
    * res0: List[Char] = List(a, c)
    * }}}
    */
  def internalList: List[T]

  /**
    * Collect the nodes at a given level in a list.
    * A node of a binary tree is at level N if the path from the root to the node
    * has length N-1. The root node is at level 1. Write a method atLevel to collect
    * all nodes at a given level in a list.
    *
    * ==Example==
    * {{{
    * scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
    * res0: List[Char] = List(b, c)
    * }}}
    */
  def atLevel(level: Int): List[T]
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

  override def leafList: List[T] = (left, right) match {
    case (End, End) => List(value)
    case _          => left.leafList ::: right.leafList
  }

  override def internalList: List[T] = (left, right) match {
    case (End, End) => Nil
    case _          => value :: left.internalList ::: right.internalList
  }

  override def atLevel(level: Int): List[T] = {
    require(level > 0, "Root is at the level 1.")

    if (level == 1) List(value)
    else left.atLevel(level - 1) ::: right.atLevel(level - 1)
  }

  override def toString: String = s"T(${value.toString} ${left.toString} ${right.toString})"
}

case object End extends Tree[Nothing] {
  override def isSymmetric: Boolean = true

  override def isMirrorOf[U](tree: Tree[U]): Boolean = tree == End

  override def leafCount: Int = 0

  override def leafList = Nil

  override def internalList = Nil

  override def atLevel(level: Int) = Nil

  override def toString: String = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}
