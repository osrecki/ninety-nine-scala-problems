package me.osrecki.prog.scala.ninety_nine.lists

import scala.collection.mutable.ListBuffer

/**
 * ==Problem==
 * Duplicate the elements of a list.
 *
 * ==Example==
 * {{{
 * scala> duplicate(List('a, 'b, 'c, 'c, 'd))
 * res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 * }}}
 */
object Problem14 {
  def duplicateBuiltIn[A](list: Seq[A]): Seq[A] = list.flatMap(elem => List(elem, elem))

  def duplicateFold[A](list: Seq[A]): Seq[A] =
    list.foldRight(Seq.empty[A]) { (elem, duplicated) => elem +: elem +: duplicated }

  def duplicateRecursive[A](list: Seq[A]): Seq[A] = {
    def innerRecursion(list: Seq[A], duplicated: Seq[A]): Seq[A] =
      list match {
        case head +: tail => innerRecursion(tail, head +: head +: duplicated)
        case _            => duplicated.reverse
      }

    innerRecursion(list, Seq.empty[A])
  }

  def duplicateBuffer[A](list: Seq[A]): Seq[A] = {
    var buffer = ListBuffer.empty[A]
    list.foreach { elem =>
      buffer += elem
      buffer += elem
    }

    buffer.toList
  }
}
