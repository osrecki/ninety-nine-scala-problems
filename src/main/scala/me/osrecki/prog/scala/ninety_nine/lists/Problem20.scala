package me.osrecki.prog.scala.ninety_nine.lists

/**
 * ==Problem==
 * Remove the Kth element from a list.
 * Return the list and the removed element in a Tuple. Elements are numbered from 0.
 *
 * ==Example==
 * {{{
 * scala> removeAt(1, List('a, 'b, 'c, 'd))
 * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd), 'b)
 * }}}
 */
object Problem20 {
  def removeAt[A](k: Int, list: Seq[A]): (Seq[A], A) = list.splitAt(k) match {
    case (Nil, _) if k < 0   => throw new NoSuchElementException
    case (pre, elem +: post) => (pre ++: post, elem)
    case (_, Nil)            => throw new NoSuchElementException
  }
}
