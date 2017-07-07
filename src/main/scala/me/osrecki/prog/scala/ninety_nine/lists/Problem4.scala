package me.osrecki.prog.scala.ninety_nine.lists

import scala.annotation.tailrec

/**
 * Find the number of elements of a list.
 *
 *  ==Example==
 *  {{{
 *  scala> length(List(1, 1, 2, 3, 5, 8))
 *  res0: Int = 6
 *  }}}
 */
object Problem4 {
  def lengthBuiltIn[A](list: Seq[A]): Int = list.length

  def lengthFold[A](list: Seq[A]): Int = list.foldLeft(0)((length, _) => length + 1)

  def lengthRecursive[A](list: Seq[A]): Int = {
    @tailrec
    def innerRecursion(list: Seq[A], length: Int): Int = list match {
      case _ +: tail => innerRecursion(tail, length + 1)
      case _         => length
    }

    innerRecursion(list, 0)
  }
}
