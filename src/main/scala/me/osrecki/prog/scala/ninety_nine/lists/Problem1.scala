package me.osrecki.prog.scala.ninety_nine.lists

/**
 * ==Problem==
 * Find the last element of a list.
 *
 * ==Example==
 * {{{
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8
 * }}}
 */
object Problem1 {
  def lastBuiltIn[A](list: Seq[A]): A = list.last

  def lastRecursive[A](list: Seq[A]): A = list match {
    case head +: Nil => head
    case _ +: tail   => lastRecursive(tail)
    case _           => throw new NoSuchElementException
  }
}
