package me.osrecki.prog.scala.ninety_nine.lists

import Problem9.packRecursive

/**
 * ==Problem==
 * Run-length encoding of a list.
 * Use the result of Problem 9 to implement the so-called run-length encoding
 * data compression method. Consecutive duplicates of elements are encoded as
 * tuples (N, E) where N is the number of duplicates of the element E.
 *
 * ==Example==
 * {{{
 * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 * }}}
 */
object Problem10 {
  def encode[A](list: Seq[A]): Seq[(Int, A)] =
    packRecursive(list).map(subList => (subList.size, subList.head))
}
