package me.osrecki.prog.scala.ninety_nine.lists

/**
 * Generate the combinations of K distinct objects chosen from the N elements
 *  of a list.
 *
 *  ==Example==
 *  {{{
 *  scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
 *  res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 *  }}}
 */
object Problem26 {
  def sublists[A](list: Seq[A]): Seq[Seq[A]] = list match {
    case _ +: tail => list +: sublists(tail)
    case _         => Seq.empty[Seq[A]]
  }

  def combinations[A](k: Int, list: Seq[A]): Seq[Seq[A]] = {
    if (k == 0) Seq(Seq.empty[A])
    else {
      sublists(list).flatMap { sublist =>
        combinations(k - 1, sublist.tail).map(sublist.head +: _)
      }
    }
  }
}
