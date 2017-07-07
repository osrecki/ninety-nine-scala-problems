package me.osrecki.prog.scala.ninety_nine.lists

import scala.annotation.tailrec

import Problem20.removeAt

/**
 * Extract a given number of randomly selected elements from a list.
 *
 *  ==Example==
 *  {{{
 *  scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 *  res0: List[Symbol] = List('e, 'd, 'a)
 *  }}}
 */
object Problem23 {
  def randomSelect[A](n: Int, list: Seq[A], seed: Long): Seq[A] = {
    val random = new util.Random(seed)

    @tailrec
    def innerRecursion(n: Int, list: Seq[A], size: Int, result: Seq[A]): Seq[A] = {
      if (n <= 0 || list.isEmpty) result
      else {
        val (rest, elem) = removeAt(random.nextInt(size), list)
        innerRecursion(n - 1, rest, size - 1, elem +: result)
      }
    }

    innerRecursion(n, list, list.size, Seq.empty[A])
  }
}
