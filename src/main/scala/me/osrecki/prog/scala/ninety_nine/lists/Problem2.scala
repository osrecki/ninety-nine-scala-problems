package me.osrecki.prog.scala.ninety_nine.lists

import java.util.NoSuchElementException

/**
 * Find the last but one element of a list.
 *
 *  ==Example==
 *  {{{
 *  scala> penultimate(List(1, 1, 2, 3, 5, 8))
 *  res0: Int = 5
 *  }}}
 */
object Problem2 {
  def penultimateBuiltIn[A](list: Seq[A]): A =
    if (list.nonEmpty) list.init.last
    else throw new NoSuchElementException

  def penultimateRecursive[A](list: Seq[A]): A = list match {
    case head +: _ +: Nil => head
    case _ +: tail        => penultimateRecursive(tail)
    case _                => throw new NoSuchElementException
  }
}
