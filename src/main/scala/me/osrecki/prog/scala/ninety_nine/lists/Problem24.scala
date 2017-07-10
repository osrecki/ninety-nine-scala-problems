package me.osrecki.prog.scala.ninety_nine.lists

import Problem23.randomSelect

/**
 * ==Problem==
 * Lotto: Draw N different random numbers from the set 1..M.
 *
 * ==Example==
 * {{{
 * scala> lotto(6, 49)
 * res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 * }}}
 */
object Problem24 {
  def lotto(n: Int, m: Int, seed: Long): Seq[Int] = randomSelect(n, 1 to m, seed)
}
