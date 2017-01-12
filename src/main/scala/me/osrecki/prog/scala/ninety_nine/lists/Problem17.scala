package me.osrecki.prog.scala.ninety_nine.lists

/**
  * Split a list into two parts.
  * The length of the first part is given. Use a Tuple for your result.
  *
  * ==Example==
  * {{{
  * scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  * }}}
  */
object Problem17 {
  def splitBuiltIn[A](n: Int, list: Seq[A]): (Seq[A], Seq[A]) = list.splitAt(n)

  def splitFunctional[A](n: Int, list: Seq[A]): (Seq[A], Seq[A]) =
    (list.take(n), list.drop(n))

  def splitRecursive[A](n: Int, list: Seq[A]): (Seq[A], Seq[A]) = {
    def innerRecursion(i: Int, list: Seq[A], first: Seq[A]): (Seq[A], Seq[A]) = {
      (i, list) match {
        case (_, Nil)           => (first.reverse, Nil)
        case (0, _)             => (first.reverse, list)
        case (_, head +: tail)  => innerRecursion(i - 1, tail, head +: first)
      }
    }

    innerRecursion(n, list, Seq.empty[A])
  }
}
