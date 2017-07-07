package me.osrecki.prog.scala.ninety_nine.lists

import scala.annotation.tailrec

/**
 * Reverse a list.
 *
 *  ==Example==
 *  {{{
 *  scala> reverse(List(1, 1, 2, 3, 5, 8))
 *  res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 *  }}}
 */
object Problem5 {
  def reverseBuiltIn[A](list: Seq[A]): Seq[A] = list.reverse

  def reverseFold[A](list: Seq[A]): Seq[A] = list.foldLeft(Seq.empty[A]) { (reversed, elem) => elem +: reversed }

  def reverseRecursive[A](list: Seq[A]): Seq[A] = {
    @tailrec
    def innerRecursion(list: Seq[A], reversed: Seq[A]): Seq[A] = list match {
      case head +: tail => innerRecursion(tail, head +: reversed)
      case _            => reversed
    }

    innerRecursion(list, Seq.empty[A])
  }
}
