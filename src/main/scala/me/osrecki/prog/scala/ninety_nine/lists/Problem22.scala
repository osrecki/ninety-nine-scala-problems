package me.osrecki.prog.scala.ninety_nine.lists

/**
 * ==Problem==
 * Create a list containing all integers within a given range.
 *
 * ==Example==
 * {{{
 * scala> range(4, 9)
 * res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 * }}}
 */
object Problem22 {
  def rangeBuiltIn(start: Int, end: Int): Seq[Int] = List.range(start, end + 1)

  def rangeRecursive(start: Int, end: Int): Seq[Int] = {
    def innerRecursion(i: Int, range: Seq[Int]): Seq[Int] = {
      if (i < start) range
      else innerRecursion(i - 1, i +: range)
    }

    innerRecursion(end, Seq.empty[Int])
  }
}
