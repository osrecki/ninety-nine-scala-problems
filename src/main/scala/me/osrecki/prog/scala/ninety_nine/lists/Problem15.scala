package me.osrecki.prog.scala.ninety_nine.lists

/**
  * Duplicate the elements of a list a given number of times.
  *
  * ==Example==
  * {{{
  * scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  * res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
  * }}}
  */
object Problem15 {
  def duplicateN[A](n: Int, list: Seq[A]): Seq[A] =
    list.flatMap { List.fill(n)(_) }
}
