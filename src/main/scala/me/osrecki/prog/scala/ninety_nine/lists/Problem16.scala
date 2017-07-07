package me.osrecki.prog.scala.ninety_nine.lists

/**
 * Drop every Nth element from a list.
 *
 *  ==Example==
 *  {{{
 *  scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *  res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 *  }}}
 */
object Problem16 {
  def dropBuiltIn[A](n: Int, list: Seq[A]): Seq[A] =
    list.zipWithIndex.filterNot { case (_, index) => (index + 1) % n == 0 }.map(_._1)

  def dropRecursive[A](n: Int, list: Seq[A]): Seq[A] = {
    def innerRecursion(k: Int, list: Seq[A], filtered: Seq[A]): Seq[A] = (k, list) match {
      case (_, Nil)          => filtered.reverse
      case (1, _ +: tail)    => innerRecursion(n, tail, filtered)
      case (_, head +: tail) => innerRecursion(k - 1, tail, head +: filtered)
    }

    innerRecursion(n, list, Seq.empty[A])
  }
}
