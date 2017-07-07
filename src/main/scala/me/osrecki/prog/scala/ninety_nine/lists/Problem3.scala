package me.osrecki.prog.scala.ninety_nine.lists

/**
 * Find the Kth element of a list.
 *  By convention, the first element in the list has index 0.
 *
 *  ==Example==
 *  {{{
 *  scala> nth(2, List(1, 1, 2, 3, 5, 8))
 *  res0: Int = 2
 *  }}}
 */
object Problem3 {
  def nthBuiltIn[A](k: Int, list: Seq[A]): A = list(k)

  def nthRecursive[A](k: Int, list: Seq[A]): A = (k, list) match {
    case (0, head +: _) => head
    case (_, _ +: tail) => nthRecursive(k - 1, tail)
    case _              => throw new IndexOutOfBoundsException
  }
}
