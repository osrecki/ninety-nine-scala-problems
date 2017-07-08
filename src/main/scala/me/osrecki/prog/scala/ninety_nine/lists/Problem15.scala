package me.osrecki.prog.scala.ninety_nine.lists

import scala.collection.mutable.ListBuffer

/**
 * ==Problem==
 * Duplicate the elements of a list a given number of times.
 *
 * ==Example==
 * {{{
 * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
 * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 * }}}
 */
object Problem15 {
  def duplicateN[A](n: Int, list: Seq[A]): Seq[A] =
    list.flatMap { List.fill(n)(_) }

  def duplicateNFold[A](n: Int, list: Seq[A]): Seq[A] =
    list.foldRight(Seq.empty[A]) { (elem, duplicated) => List.fill(n)(elem) ++ duplicated }

  def duplicateNRecursive[A](n: Int, list: Seq[A]): Seq[A] = {
    def innerRecursion(list: Seq[A], duplicated: Seq[A]): Seq[A] =
      list match {
        case head +: tail => innerRecursion(tail, List.fill(n)(head) ++ duplicated)
        case _            => duplicated.reverse
      }

    innerRecursion(list, Seq.empty[A])
  }

  def duplicateNBuffer[A](n: Int, list: Seq[A]): Seq[A] = {
    var buffer = ListBuffer.empty[A]
    list.foreach { elem =>
      for (_ <- 0 until n) { buffer += elem }
    }

    buffer.toList
  }
}
