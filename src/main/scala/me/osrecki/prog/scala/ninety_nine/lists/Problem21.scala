package me.osrecki.prog.scala.ninety_nine.lists

/**
 * Insert an element at a given position into a list.
 *
 *  ==Example==
 *  {{{
 *  scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
 *  res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 *  }}}
 */
object Problem21 {
  def insertAt[A](elem: A, k: Int, list: Seq[A]): Seq[A] =
    list.splitAt(k) match {
      case (first, second) => first ++: elem +: second
    }
}
